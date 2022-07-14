package it.accenture.bootcamp.repositories.implementations;

import it.accenture.bootcamp.models.Sector;
import it.accenture.bootcamp.repositories.abstractions.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
@Profile("jdbc")
public class JdbcSectorRepository implements SectorRepository {
    private JdbcTemplate template;

    @Autowired
    public JdbcSectorRepository(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Sector> findAll() {
        return template.query("SELECT * FROM COURSE", this::rowMapper);
    }

    @Override
    public List<Sector> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Sector> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Sector> findAllById(Iterable<Long> longs) {
        //
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long id) {
        template.update("DELETE FROM COURSE WHERE ID = ?", new Object[] { id });
    }

    @Override
    public <S extends Sector> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Sector> findById(Long id) {
        Sector c = template.queryForObject("SELECT COURSE WHERE ID = ?", new Object[] { id }, this::rowMapper);
        if (c == null)
            return Optional.empty();
        else
            return Optional.of(c);
    }

    @Override
    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Sector> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Sector> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Sector> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Sector getOne(Long aLong) {
        return null;
    }

    @Override
    public Sector getById(Long id) {
        return findById(id).isPresent() ? findById(id).get() : null;
    }

    @Override
    public Sector getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Sector> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Sector> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Sector> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Sector> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Sector> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Sector> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Sector, R> R findBy(Example<S> example,
            Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    private Sector rowMapper(ResultSet rs, int rownNum) throws SQLException {
        return new Sector(rs.getLong("ID"), rs.getString("NAME"));
    }

    @Override
    public void delete(Sector c) {
        deleteById(c.getId());
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        for (Long id : longs)
            deleteById(id);
    }

    @Override
    public void deleteAll(Iterable<? extends Sector> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Sector save(Sector c) {
        if (existsById(c.getId())) { // update
            template.update("UPDATE CLASSROOM (ID, NAME))" +
                    " VALUES (?, ?)", getComponents(c));
        } else { // save
            template.update("Insert INTO CLASSROOM ((ID, NAME)" +
                    " VALUES (?, ?)", getComponents(c));
        }
        return c;
    }

    public Object[] getComponents(Sector c) {
        return new Object[] { c.getId(), c.getName() };
    }
}
