package org.store.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.store.webapp.model.Subcategory;
import org.store.webapp.repository.ISubcategoryRepository;
import org.store.webapp.util.ExceptionCheck;

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
        return ExceptionCheck.check(repository.getAllById(id), id);
    }

    @Override
    public Subcategory getById(Integer id) {
        return ExceptionCheck.check(repository.getById(id), id);
    }

    @Override
    public Subcategory save(Subcategory category) {
        return repository.save(category);
    }

    @Override
    public void delete(Integer id) {
        ExceptionCheck.check(repository.getById(id), id);
        repository.delete(id);
    }

    @Override
    public void update(Subcategory category) {
        ExceptionCheck.check(repository.getById(category.getIdSubcategory()), category.getIdSubcategory());
        repository.save(category);
    }
}
