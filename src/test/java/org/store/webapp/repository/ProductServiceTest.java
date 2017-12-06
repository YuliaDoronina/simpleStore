package org.store.webapp.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.store.webapp.model.Product;
import org.store.webapp.service.ProductService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public abstract class ProductServiceTest {

    @Autowired
    private ProductService service;

    @Test
    public void getAll() throws Exception {
        List<Product> info = service.getAll();
        Assert.assertEquals(45, info.size());
      /*  Assert.assertArrayEquals(new Product[]{PRODUCT1, PRODUCT2, PRODUCT3}, info.toArray());*/
    }
}
