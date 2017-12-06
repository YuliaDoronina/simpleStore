package org.store.webapp.repository.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
        List<Product> products = new ArrayList<>();
        List<Map<String, Object>> rows = template.queryForList("SELECT * FROM product");
        for (Map row : rows) {
            Product product = new Product();
            product.setId((Integer) row.get("id_product"));
            product.setName((String) row.get("name_product"));
            product.setPrice((String) row.get("price_product"));
            product.setDescription((String) row.get("description_product"));
            product.setFlag((Boolean) row.get("flag_product"));
            products.add(product);
        }

        LOGGER.info("Get all: {}", products);
        return products;
    }
}
