package org.store.webapp.repository.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.store.webapp.model.Subcategory;
import org.store.webapp.repository.ISubcategoryRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SubcategoryRepository implements ISubcategoryRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(Subcategory.class);

    @Autowired
    private JdbcTemplate template;

    @Autowired
    private DataSource source;

    private final BeanPropertyRowMapper<Subcategory> rowMapper = BeanPropertyRowMapper.newInstance(Subcategory.class);

    private SimpleJdbcInsert insert;

    public SubcategoryRepository(DataSource dataSource) {
        this.insert = new SimpleJdbcInsert(dataSource)
                .withTableName("subcategory")
                .usingGeneratedKeyColumns("id_subcategory");
    }

    @Override
    public List getAll() {
        return template.query("SELECT * FROM subcategory", rowMapper);
    }

    @Override
    public List getAllById(Integer id) {
        List<Map<String, Object>> rows = template.queryForList("SELECT * FROM subcategory WHERE subcategory.id_category=?", id);
        return getInfo(rows);
    }

    private List getInfo(List<Map<String, Object>> rows) {
        List<Subcategory> subcategories = new ArrayList<>();
        for (Map row : rows) {
            Subcategory subcategory = new Subcategory();
            subcategory.setIdSubcategory((Integer) row.get("id_subcategory"));
            subcategory.setNameSubcategory((String) row.get("name_subcategory"));
            subcategories.add(subcategory);
        }

        LOGGER.info("Get all subcategories: {}", subcategories);
        return subcategories;
    }

    @Override
    public Subcategory getById(Integer id) {
        LOGGER.info("Get subcategory by id: {}", id);
        try {
            return template.queryForObject("SELECT * FROM subcategory WHERE subcategory.id_subcategory=?", rowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Subcategory save(Subcategory subcategory) {
        LOGGER.info("Save subcategory: {}", subcategory);

        Connection connection = null;
        try {
            connection = source.getConnection();
            PreparedStatement statement;
            if (subcategory.getIdSubcategory() == null) {
                statement = connection.prepareStatement("INSERT INTO subcategory (name_subcategory, id_category) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    subcategory.setIdSubcategory(resultSet.getInt(1));
                }
            } else {
                statement = connection.prepareStatement("UPDATE subcategory SET name_subcategory=?, id_category=? WHERE id_subcategory=?");
                statement.setInt(3, subcategory.getIdSubcategory());
            }

            statement.setString(1, subcategory.getNameSubcategory());
            statement.setInt(2, subcategory.getValueCategory());
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
        return subcategory;
    }

    @Override
    public boolean delete(Integer id) {
        LOGGER.info("Delete subcategory by id: {}", id);
        return template.update("DELETE FROM subcategory WHERE subcategory.id_subcategory=?", id) > 0;
    }
}
