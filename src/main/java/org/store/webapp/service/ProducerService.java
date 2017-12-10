package org.store.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.store.webapp.model.Producer;
import org.store.webapp.repository.IProducerRepository;

import java.util.List;

@Service
public class ProducerService implements IProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private IProducerRepository repository;

    @Override
    public List<Producer> getAllByCategory(Integer id) {
        List list = repository.getAllByCategory(id);
        LOGGER.info("Get all by subcategory: {}", list);
        return list;
    }
}
