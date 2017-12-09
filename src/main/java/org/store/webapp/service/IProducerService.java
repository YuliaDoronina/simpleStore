package org.store.webapp.service;

import org.store.webapp.model.Producer;

import java.util.List;

public interface IProducerService {

    List<Producer> getAllBySubcategory(Integer id);

}
