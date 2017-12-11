package org.store.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.store.webapp.model.Category;
import org.store.webapp.repository.ICategoryRepository;
import org.store.webapp.util.ExceptionCheck;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository repository;

    @Override
    public List<Category> getAll() {
        return repository.getAll();
    }

    @Override
    public Category getById(Integer id) {
        return ExceptionCheck.check(repository.getById(id), id);
    }

    @Override
    public Category save(Category category) {
        return repository.save(category);
    }

    @Override
    public void delete(Integer id) {
        ExceptionCheck.check(repository.getById(id), id);
        repository.delete(id);
    }

    @Override
    public void update(Category category) {
        ExceptionCheck.check(repository.getById(category.getIdCategory()), category.getIdCategory());
        repository.save(category);
    }
}
