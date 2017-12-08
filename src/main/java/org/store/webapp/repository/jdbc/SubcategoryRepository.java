package org.store.webapp.repository.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.store.webapp.model.Subcategory;
import org.store.webapp.repository.ISubcategoryRepository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SubcategoryRepository implements ISubcategoryRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(Subcategory.class);

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate template;

    private final BeanPropertyRowMapper<Subcategory> rowMapper = BeanPropertyRowMapper.newInstance(Subcategory.class);

    private SimpleJdbcInsert insert;

    public SubcategoryRepository(DataSource dataSource) {
        this.insert = new SimpleJdbcInsert(dataSource)
                .withTableName("subcategory")
                .usingGeneratedKeyColumns("id_subcategory");
    }

    @Override
    public List getAll() {
        List<Map<String, Object>> rows = template.queryForList("SELECT * FROM subcategory");
        return getInfo(rows);
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
            subcategory.setId((Integer) row.get("id_subcategory"));
            subcategory.setName((String) row.get("name_subcategory"));
            subcategory.setIdCategory((Integer) row.get("id_category"));
            subcategories.add(subcategory);
        }
        return subcategories;
    }

}
