package org.store.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.store.webapp.model.Product;
import org.store.webapp.repository.IProductRepository;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository repository;

    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Product> getAllById(Integer id) {
        return repository.getAllById(id);
    }

    @Override
    public List<Product> getAllByProducer(Integer idProducer, Integer idCategory) {
        return repository.getAllByProducer(idProducer, idCategory);
    }

    @Override
    public Product getById(Integer id) {
        return repository.getById(id);
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Override
    public void update(Product product) {
        repository.save(product);
    }
}
