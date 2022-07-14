package it.accenture.bootcamp.services.abstractions;

import it.accenture.bootcamp.exceptions.EntityNotFoundException;

import java.util.Optional;

public interface AbstractCrudService<T, K> {
    Iterable<T> getAll();
    Optional<T> findById(K k);
    void deleteById(K k) throws EntityNotFoundException;
    T saveOrUpdate(T t) throws EntityNotFoundException;
    boolean exists(K id);
}
