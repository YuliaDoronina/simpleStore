package org.store.webapp.repository.jdbc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.store.webapp.model.Category;
import org.store.webapp.BaseClassTest;
import org.store.webapp.service.CategoryService;
import org.store.webapp.util.NotFoundException;

import java.util.List;

import static org.store.webapp.DataClass.*;

public class CategoryRepositoryTest extends BaseClassTest {

    @Autowired
    private CategoryService service;

    @Test
    public void getAll() throws Exception {
        List<Category> categoryList = service.getAll();
        Assert.assertEquals(2, categoryList.size());
        Assert.assertArrayEquals(new Category[]{CATEGORY1, CATEGORY2}, categoryList.toArray());
    }

    @Test
    public void getById() throws Exception {
        Category category = service.getById(1);
        Assert.assertEquals(CATEGORY1, category);
    }

    @Test
    public void save() throws Exception {
        Category category = new Category("name");
        Category categorySave = service.save(category);
        category.setIdCategory(3);
        Assert.assertEquals(category, categorySave);
        Assert.assertEquals(3, service.getAll().size());
    }

    @Test
    public void delete() throws Exception {
        service.delete(1);
        Assert.assertEquals(1, service.getAll().size());
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() throws Exception {
        service.delete(0);
    }

    @Test(expected = NotFoundException.class)
    public void updateNotFound() throws Exception {
        service.update(CATEGORY3);
    }
}