package it.accenture.bootcamp.services.implementations;

import it.accenture.bootcamp.models.Course;
import it.accenture.bootcamp.services.abstractions.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseCrudService extends CrudService<Course, Long, JpaRepository<Course, Long>> {

    public CourseCrudService(JpaRepository<Course, Long> repo) {
        super(repo);
    }
}
