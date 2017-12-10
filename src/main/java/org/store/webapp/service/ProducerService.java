package org.store.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.store.webapp.model.Producer;
import org.store.webapp.repository.IProducerRepository;

import java.util.List;

@Service
public class ProducerService implements IProducerService {

    @Autowired
    private IProducerRepository repository;

    @Override
    public List<Producer> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Producer> getAllByCategory(Integer id) {
        return repository.getAllByCategory(id);
    }

    @Override
    public Producer getById(Integer id) {
        return repository.getById(id);
    }

    @Override
    public Producer save(Producer producer) {
        return repository.save(producer);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Override
    public void update(Producer producer) {
        repository.save(producer);
    }
}
