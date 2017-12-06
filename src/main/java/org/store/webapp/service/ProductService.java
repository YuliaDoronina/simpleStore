package org.store.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.store.webapp.model.Product;
import org.store.webapp.repository.IProductRepository;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(Product.class);

    @Autowired
    private IProductRepository repository;

    @Override
    public List<Product> getAll() {
        List list = repository.getAll();
        LOGGER.info("Get all: {}", list);
        return list;
    }
}
