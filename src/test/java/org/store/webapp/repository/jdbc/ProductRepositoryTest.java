package org.store.webapp.repository.jdbc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.store.webapp.model.Product;
import org.store.webapp.BaseClassTest;
import org.store.webapp.service.ProductService;
import org.store.webapp.util.NotFoundException;

import java.util.List;

import static org.store.webapp.DataClass.*;

public class ProductRepositoryTest extends BaseClassTest {

    @Autowired
    private ProductService service;

    @Test
    public void getAll() throws Exception {
        List<Product> categoryList = service.getAll();
        Assert.assertEquals(2, categoryList.size());
        Assert.assertArrayEquals(new Product[]{PRODUCT1, PRODUCT2}, categoryList.toArray());
    }

    @Test
    public void getAllById() throws Exception {
        List<Product> list = service.getAllById(2);
        Assert.assertEquals(1, list.size());
        Assert.assertArrayEquals(new Product[]{PRODUCT2}, list.toArray());
    }

    @Test
    public void getAllByProducer() throws Exception {
        List<Product> list = service.getAllByProducer(2, 1);
        Assert.assertEquals(1, list.size());
        Assert.assertArrayEquals(new Product[]{PRODUCT1}, list.toArray());
    }

    @Test
    public void getById() throws Exception {
        Product product = service.getById(1);
        Assert.assertEquals(PRODUCT1, product);
    }

    @Test
    public void save() throws Exception {
        Product product = new Product("name", "price", "description", true, 1);
        Product productSave = service.save(product);
        product.setIdProduct(3);
        Assert.assertEquals(product, productSave);
        Assert.assertEquals(3, service.getAll().size());
    }

    @Test
    public void delete() throws Exception {
        service.delete(2);
        Assert.assertEquals(1, service.getAll().size());
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() throws Exception {
        service.delete(0);
    }

    @Test(expected = NotFoundException.class)
    public void updateNotFound() throws Exception {
        service.update(PRODUCT3);
    }
}