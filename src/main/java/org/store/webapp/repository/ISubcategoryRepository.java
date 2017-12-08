package org.store.webapp.repository;

import java.util.List;

public interface ISubcategoryRepository {

    List getAll();

    List getAllById(Integer id);
}
