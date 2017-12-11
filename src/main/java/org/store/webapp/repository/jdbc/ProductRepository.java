package org.store.webapp.repository.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.store.webapp.model.Product;
import org.store.webapp.repository.IProductRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(Product.class);

    @Autowired
    private JdbcTemplate template;

    @Autowired
    private DataSource source;

    private final BeanPropertyRowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);

    private SimpleJdbcInsert insert;

    public ProductRepository(DataSource dataSource) {
        this.insert = new SimpleJdbcInsert(dataSource)
                .withTableName("product")
                .usingGeneratedKeyColumns("id_product");
    }

    @Override
    public List getAll() {
        return template.query("SELECT * FROM product", rowMapper);
    }

    @Override
    public List getAllById(Integer id) {
        List<Map<String, Object>> rows = template.queryForList("SELECT * FROM product WHERE product.id_subcategory=?", id);
        return getInfo(rows);
    }

    @Override
    public List getAllByProducer(Integer idProducer, Integer idCategory) {
        List<Map<String, Object>> rows = template.queryForList("SELECT\n" +
                "product.id_product,\n" +
                "product.name_product,\n" +
                "product.price_product,\n" +
                "product.description_product,\n" +
                "product.flag_product\n" +
                "FROM product\n" +
                "INNER JOIN summary ON product.id_product = summary.id_product\n" +
                "JOIN producer ON summary.id_producer = producer.id_producer\n" +
                "INNER JOIN subcategory ON product.id_subcategory = subcategory.id_subcategory\n" +
                "JOIN category ON subcategory.id_category = category.id_category\n" +
                "WHERE producer.id_producer=? AND category.id_category=?", idProducer, idCategory);

        return getInfo(rows);
    }

    private List getInfo(List<Map<String, Object>> rows) {
        List<Product> products = new ArrayList<>();
        for (Map row : rows) {
            Product product = new Product();
            product.setIdProduct((Integer) row.get("id_product"));
            product.setNameProduct((String) row.get("name_product"));
            product.setPriceProduct((String) row.get("price_product"));
            product.setDescriptionProduct((String) row.get("description_product"));
            product.setFlagProduct((Boolean) row.get("flag_product"));
            products.add(product);
        }
        LOGGER.info("Get all products: {}", products);

        return products;
    }

    @Override
    public Product getById(Integer id) {
        LOGGER.info("Get product by id: {}", id);
        try {
            return template.queryForObject("SELECT * FROM product WHERE product.id_product=?", rowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Product save(Product product) {
        LOGGER.info("Save product: {}", product);

        Connection connection = null;
        try {
            connection = source.getConnection();
            PreparedStatement statement;
            if (product.getIdProduct() == null) {
                statement = connection.prepareStatement("INSERT INTO product (name_product, price_product, description_product, flag_product, id_subcategory) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    product.setIdProduct(resultSet.getInt(1));
                }
            } else {
                statement = connection.prepareStatement("UPDATE product SET name_product=?, price_product=?, description_product=?, flag_product=?, id_subcategory=? WHERE id_product=?");
                statement.setInt(6, product.getIdProduct());
            }

            statement.setString(1, product.getNameProduct());
            statement.setString(2, product.getPriceProduct());
            statement.setString(3, product.getDescriptionProduct());
            statement.setBoolean(4, product.getFlagProduct());
            statement.setInt(5, product.getValueSubcategory());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return product;
    }

    @Override
    public boolean delete(Integer id) {
        LOGGER.info("Delete product by id: {}", id);
        return template.update("DELETE FROM product WHERE product.id_product=?", id) > 0;
    }
}
