package it.accenture.bootcamp.services.implementations;

import it.accenture.bootcamp.models.Classroom;
import it.accenture.bootcamp.services.abstractions.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ClassroomCrudService extends CrudService<Classroom, Long, JpaRepository<Classroom, Long>> {

    public ClassroomCrudService(JpaRepository<Classroom, Long> repo) {
        super(repo);
    }
}
