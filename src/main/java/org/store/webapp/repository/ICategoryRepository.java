package org.store.webapp.repository;

import org.store.webapp.model.Category;

import java.util.List;

public interface ICategoryRepository {

    List getAll();

    Category getById(Integer id);

    Category save(Category category);

    boolean delete(Integer id);
}
