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
                .usingGeneratedKeyColumns("id_category");
    }

    @Override
    public List getAll() {
        List<Category> categories = new ArrayList<>();
        List<Map<String, Object>> rows = template.queryForList("SELECT * FROM category");
        for (Map row : rows) {
            Category category = new Category();
            category.setIdCategory((Integer) row.get("id_category"));
            category.setTypeCategory((String) row.get("type_category"));
            categories.add(category);
        }

        LOGGER.info("Get all category: {}", categories);
        return categories;
    }

    @Override
    public Category getById(Integer id) {
        LOGGER.info("Get category by id: {}", id);
        try {
            return template.queryForObject("SELECT * FROM category WHERE category.id_category=?", rowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Category save(Category category) {
        LOGGER.info("Save category: {}", category);
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("typeCategory", category.getTypeCategory());

        if (category.getIdCategory() == null) {
            Number number = insert.executeAndReturnKey(map);
            category.setIdCategory(number.intValue());
        } else {
            map.addValue("idCategory", category.getIdCategory());
            namedParameterJdbcTemplate
                    .update("UPDATE category SET type_category=:typeCategory WHERE id_category=:idCategory", map);
        }
        return category;
    }

    @Override
    public boolean delete(Integer id) {
        LOGGER.info("Delete category by id: {}", id);
        return template.update("DELETE FROM category WHERE category.id_category=?", id) > 0;
    }
}
