package org.store.webapp.repository;

import org.store.webapp.model.Producer;

import java.util.List;

public interface IProducerRepository {

    List getAll();

    List getAllByCategory(Integer id);

    Producer getById(Integer id);

    Producer save(Producer producer);

    boolean delete(Integer id);
}
