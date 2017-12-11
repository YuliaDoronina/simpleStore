package org.store.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.store.webapp.model.Producer;
import org.store.webapp.repository.IProducerRepository;
import org.store.webapp.util.ExceptionCheck;

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
        return ExceptionCheck.check(repository.getAllByCategory(id), id);
    }

    @Override
    public Producer getById(Integer id) {
        return ExceptionCheck.check(repository.getById(id), id);
    }

    @Override
    public Producer save(Producer producer) {
        return repository.save(producer);
    }

    @Override
    public void delete(Integer id) {
        ExceptionCheck.check(repository.getById(id), id);
        repository.delete(id);
    }

    @Override
    public void update(Producer producer) {
        ExceptionCheck.check(repository.getById(producer.getIdProducer()), producer.getIdProducer());
        repository.save(producer);
    }
}
