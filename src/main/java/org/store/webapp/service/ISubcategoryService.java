package org.store.webapp.service;

import org.store.webapp.model.Subcategory;

import java.util.List;

public interface ISubcategoryService {

    List<Subcategory> getAll();

    List<Subcategory> getAllById(Integer id);

    Subcategory getById(Integer id);

    Subcategory save(Subcategory category);

    void delete(Integer id);

    void update(Subcategory category);
}
