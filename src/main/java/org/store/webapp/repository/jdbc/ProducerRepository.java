package org.store.webapp.repository.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.store.webapp.model.Producer;
import org.store.webapp.repository.IProducerRepository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ProducerRepository implements IProducerRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate template;

    private final BeanPropertyRowMapper<Producer> rowMapper = BeanPropertyRowMapper.newInstance(Producer.class);

    private SimpleJdbcInsert insert;

    public ProducerRepository(DataSource dataSource) {
        this.insert = new SimpleJdbcInsert(dataSource)
                .withTableName("producer")
                .usingGeneratedKeyColumns("id_producer");
    }

    @Override
    public List getAllByCategory(Integer id) {
        List<Producer> producers = new ArrayList<>();
        List<Map<String, Object>> rows = template.queryForList("SELECT " +
                "producer.id_producer, " +
                "producer.name_producer " +
                "FROM producer " +
                "INNER JOIN summary ON producer.id_producer = summary.id_producer\n" +
                "JOIN product ON summary.id_product = product.id_product\n" +
                "JOIN subcategory ON product.id_subcategory = subcategory.id_subcategory " +
                "JOIN category ON subcategory.id_category = category.id_category\n" +
                "WHERE category.id_category=? " +
                "GROUP BY producer.id_producer", id);

        for (Map row : rows) {
            Producer product = new Producer();
            product.setId((Integer) row.get("id_producer"));
            product.setName((String) row.get("name_producer"));
            producers.add(product);
        }
        return producers;
    }
}
