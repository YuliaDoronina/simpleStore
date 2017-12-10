package org.store.webapp.service;

import org.store.webapp.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> getAll();

    Category getById(Integer id);

    Category save(Category category);

    void delete(Integer id);

    void update(Category category);
}
