package org.store.webapp.repository;

import org.store.webapp.model.Product;

import java.util.List;

public interface IProductRepository {

    List getAll();

    List getAllById(Integer id);

    List getAllByProducer(Integer idProducer, Integer idCategory);

    Product getById(Integer id);

    Product save(Product product);

    boolean delete(Integer id);
}
