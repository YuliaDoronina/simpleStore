package org.store.webapp.repository;

import org.store.webapp.model.Subcategory;

import java.util.List;

public interface ISubcategoryRepository {

    List getAll();

    List getAllById(Integer id);

    Subcategory getById(Integer id);

    Subcategory save(Subcategory subcategory);

    boolean delete(Integer id);
}
