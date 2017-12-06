package org.store.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.store.webapp.model.Category;
import org.store.webapp.repository.ICategoryRepository;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(Category.class);

    @Autowired
    private ICategoryRepository repository;

    @Override
    public List<Category> getAll() {
        List list = repository.getAll();
        LOGGER.info("Get all: {}", list);
        return list;
    }
}
