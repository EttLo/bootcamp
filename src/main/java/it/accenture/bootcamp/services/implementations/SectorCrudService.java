package it.accenture.bootcamp.services.implementations;

import it.accenture.bootcamp.models.Sector;
import it.accenture.bootcamp.services.abstractions.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SectorCrudService extends CrudService<Sector, Long, JpaRepository<Sector, Long>> {

    public SectorCrudService(JpaRepository<Sector, Long> repo) {
        super(repo);
    }
}
