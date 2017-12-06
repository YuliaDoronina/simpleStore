package org.store.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.store.webapp.model.Category;
import org.store.webapp.model.Subcategory;
import org.store.webapp.repository.ISubcategoryRepository;

import java.util.List;

@Service
public class SubcategoryService implements ISubcategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(Subcategory.class);

    @Autowired
    private ISubcategoryRepository repository;

    @Override
    public List<Subcategory> getAll() {
        List list = repository.getAll();
        LOGGER.info("Get all: {}", list);
        return list;
    }
}
