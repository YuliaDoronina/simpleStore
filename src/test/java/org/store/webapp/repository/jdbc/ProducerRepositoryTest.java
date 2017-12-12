package org.store.webapp.repository.jdbc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.store.webapp.model.Producer;
import org.store.webapp.BaseClassTest;
import org.store.webapp.service.ProducerService;
import org.store.webapp.util.NotFoundException;

import java.util.List;

import static org.store.webapp.DataClass.*;

public class ProducerRepositoryTest extends BaseClassTest {

    @Autowired
    private ProducerService service;

    @Test
    public void getAll() throws Exception {
        List<Producer> categoryList = service.getAll();
        Assert.assertEquals(2, categoryList.size());
        Assert.assertArrayEquals(new Producer[]{PRODUCER1, PRODUCER2}, categoryList.toArray());
    }

    @Test
    public void getAllByCategory() throws Exception {
        List<Producer> list = service.getAllByCategory(2);
        Assert.assertEquals(1, list.size());
        Assert.assertArrayEquals(new Producer[]{PRODUCER1}, list.toArray());
    }

    @Test
    public void getById() throws Exception {
        Producer producer = service.getById(1);
        Assert.assertEquals(PRODUCER1, producer);
    }

    @Test
    public void save() throws Exception {
        Producer producer = new Producer("name");
        Producer producerSave = service.save(producer);
        producer.setIdProducer(3);
        Assert.assertEquals(producer, producerSave);
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
        service.update(PRODUCER3);
    }
}