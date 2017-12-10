package org.store.webapp.repository;

import java.util.List;

public interface IProductRepository {

    List getAll();

    List getAllById(Integer id);

    List getAllByProducer(Integer idProducer, Integer idCategory);
}
