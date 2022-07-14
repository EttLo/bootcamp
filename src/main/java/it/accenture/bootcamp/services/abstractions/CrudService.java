package it.accenture.bootcamp.services.abstractions;

import it.accenture.bootcamp.exceptions.EntityNotFoundException;
import it.accenture.bootcamp.models.Classroom;
import it.accenture.bootcamp.models.WithId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static it.accenture.bootcamp.services.implementations.EducationServiceImpl.ERROR_NOT_FOUND;

//@Service
public class CrudService<T extends WithId<K>, K, R extends JpaRepository<T, K>> implements AbstractCrudService<T, K>{
    private R repo;
    public CrudService(R repo){
        this.repo = repo;
    }

    @Override
    public Iterable<T> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<T> findById(K k) {
        return repo.findById(k);
    }

    @Override
    public void deleteById(K k) throws EntityNotFoundException {
        if (exists(k)) {
            repo.deleteById(k);
        } else {
            throw new EntityNotFoundException(ERROR_NOT_FOUND, Classroom.class, (long) k);
        }
    }

    @Override
    public T saveOrUpdate(T t) throws EntityNotFoundException {
        if (!t.getId().equals(0) && !exists(t.getId())) {
            throw new EntityNotFoundException(ERROR_NOT_FOUND, Classroom.class, (long) t.getId());
        }
        return repo.save(t);
    }

    @Override
    public boolean exists(K id) {
        return findById(id).isPresent();
    }
}
