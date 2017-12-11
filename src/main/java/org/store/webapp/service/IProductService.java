package org.store.webapp.service;

import org.store.webapp.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAll();

    List<Product> getAllById(Integer id);

    List<Product> getAllByProducer(Integer idProducer, Integer idCategory);

    Product getById(Integer id);

    Product save(Product product);

    void delete(Integer id);

    void update(Product product);
}
