package org.store.webapp.service;

import org.store.webapp.model.Producer;

import java.util.List;

public interface IProducerService {

    List<Producer> getAll();

    List getAllByCategory(Integer id);

    Producer getById(Integer id);

    Producer save(Producer producer);

    void delete(Integer id);

    void update(Producer producer);
}
