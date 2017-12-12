package org.store.webapp.repository.jdbc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.store.webapp.model.Subcategory;
import org.store.webapp.BaseClassTest;
import org.store.webapp.service.SubcategoryService;
import org.store.webapp.util.NotFoundException;

import java.util.List;

import static org.store.webapp.DataClass.*;

public class SubcategoryRepositoryTest extends BaseClassTest {

    @Autowired
    private SubcategoryService service;

    @Test
    public void getAll() throws Exception {
        List<Subcategory> categoryList = service.getAll();
        Assert.assertEquals(2, categoryList.size());
        Assert.assertArrayEquals(new Subcategory[]{SUBCATEGORY1, SUBCATEGORY2}, categoryList.toArray());
    }

    @Test
    public void getAllById() throws Exception {
        List<Subcategory> list = service.getAllById(2);
        Assert.assertEquals(1, list.size());
        Assert.assertArrayEquals(new Subcategory[]{SUBCATEGORY2}, list.toArray());
    }

    @Test
    public void getById() throws Exception {
        Subcategory subcategory = service.getById(1);
        Assert.assertEquals(SUBCATEGORY1, subcategory);
    }

    @Test
    public void save() throws Exception {
        Subcategory subcategory = new Subcategory("name", 1);
        Subcategory subcategorySave = service.save(subcategory);
        subcategory.setIdSubcategory(3);
        Assert.assertEquals(subcategory, subcategorySave);
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
        service.update(SUBCATEGORY3);
    }
}