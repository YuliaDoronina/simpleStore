package org.store.webapp.repository.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.store.webapp.model.Category;
import org.store.webapp.repository.ICategoryRepository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CategoryRepository implements ICategoryRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(Category.class);

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate template;

    private final BeanPropertyRowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);

    private SimpleJdbcInsert insert;

    public CategoryRepository(DataSource dataSource) {
        this.insert = new SimpleJdbcInsert(dataSource)
                .withTableName("category")
                .usingColumns("id_category");
    }

    @Override
    public List getAll() {
        List<Category> categories = new ArrayList<>();
        List<Map<String, Object>> rows = template.queryForList("SELECT * FROM category");
        for (Map row : rows) {
            Category category = new Category();
            category.setId((Integer) row.get("id_category"));
            category.setName((String) row.get("type_category"));
            categories.add(category);
        }
        return categories;
    }
}
