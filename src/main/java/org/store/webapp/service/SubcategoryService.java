package org.store.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.store.webapp.model.Subcategory;
import org.store.webapp.repository.ISubcategoryRepository;

import java.util.List;

@Service
public class SubcategoryService implements ISubcategoryService {

    @Autowired
    private ISubcategoryRepository repository;

    @Override
    public List<Subcategory> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Subcategory> getAllById(Integer id) {
        return repository.getAllById(id);
    }

    @Override
    public Subcategory getById(Integer id) {
        return repository.getById(id);
    }

    @Override
    public Subcategory save(Subcategory category) {
        return repository.save(category);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Override
    public void update(Subcategory category) {
        repository.save(category);
    }
}
