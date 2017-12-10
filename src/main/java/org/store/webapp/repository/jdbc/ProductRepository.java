package org.store.webapp.repository.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.store.webapp.model.Product;
import org.store.webapp.repository.IProductRepository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(Product.class);

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate template;

    private final BeanPropertyRowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);

    private SimpleJdbcInsert insert;

    public ProductRepository(DataSource dataSource) {
        this.insert = new SimpleJdbcInsert(dataSource)
                .withTableName("product")
                .usingColumns("id_product");
    }

    @Override
    public List getAll() {
        List<Map<String, Object>> rows = template.queryForList("SELECT * FROM product");
        return getInfo(rows);
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
            product.setId((Integer) row.get("id_product"));
            product.setName((String) row.get("name_product"));
            product.setPrice((String) row.get("price_product"));
            product.setDescription((String) row.get("description_product"));
            product.setFlag((Boolean) row.get("flag_product"));
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
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("name", product.getName());
        map.addValue("price", product.getPrice());
        map.addValue("description", product.getDescription());
        map.addValue("flag", product.getFlag());

        if (product.getId() == null) {
            Number number = insert.executeAndReturnKey(map);
            product.setId(number.intValue());
        } else {
            map.addValue("id", product.getId());
            namedParameterJdbcTemplate.update("UPDATE product SET name_product=:name, price_product=:price, description_product=:description, flag_product=:flag WHERE id_product=:id", map);
        }
        return product;
    }

    @Override
    public boolean delete(Integer id) {
        LOGGER.info("Delete product by id: {}", id);
        return template.update("DELETE FROM product WHERE product.id_product=?", id) > 0;
    }
}
