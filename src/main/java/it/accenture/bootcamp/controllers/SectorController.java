package it.accenture.bootcamp.controllers;

import it.accenture.bootcamp.dtos.SectorDTO;
import it.accenture.bootcamp.exceptions.EntityNotFoundException;
import it.accenture.bootcamp.mappers.SectorMapper;
import it.accenture.bootcamp.models.Sector;
import it.accenture.bootcamp.services.abstractions.EducationService;
import it.accenture.bootcamp.services.implementations.SectorCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("sector")
public class SectorController {
    private EducationService eduService;
    private SectorCrudService crudService;

    @Autowired
    public SectorController(EducationService eduService, SectorCrudService crudService) {
        this.eduService = eduService;
        this.crudService = crudService;
    }

    @GetMapping
    public ResponseEntity<Iterable<SectorDTO>> getAll() {
        var cls = crudService.getAll();
        var dtos = StreamSupport.stream(cls.spliterator(), false).map(SectorMapper.INSTANCE::toSectorDto).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SectorDTO> findById(@PathVariable long id) {
        Optional<Sector> optClass = crudService.findById(id);
        if (optClass.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optClass.map(SectorMapper.INSTANCE::toSectorDto).get());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        try {
            crudService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody SectorDTO sdto) {
        Sector s = SectorMapper.INSTANCE.toSector(sdto);
        try {
            Sector sSaved = crudService.saveOrUpdate(s);
            var dto = SectorMapper.INSTANCE.toSectorDto(sSaved);
            URI uri = new URI("localhost:8080/sector/" + sdto.getId());
            return ResponseEntity.created(uri).body(dto);
        } catch (URISyntaxException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody SectorDTO sdto, @PathVariable long id) {
        Sector s = SectorMapper.INSTANCE.toSector(sdto);
        try {
            Sector sSaved = crudService.saveOrUpdate(s);
            SectorDTO dto = SectorMapper.INSTANCE.toSectorDto(sSaved);
            return ResponseEntity.ok(dto);

        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
