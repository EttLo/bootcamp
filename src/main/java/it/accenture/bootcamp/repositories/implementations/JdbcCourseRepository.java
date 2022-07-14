package it.accenture.bootcamp.repositories.implementations;

import it.accenture.bootcamp.models.Course;
import it.accenture.bootcamp.models.Course;
import it.accenture.bootcamp.repositories.abstractions.CourseRepository;
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
public class JdbcCourseRepository implements CourseRepository {
    private JdbcTemplate template;

    @Autowired
    public JdbcCourseRepository(JdbcTemplate template) {
        this.template = template;
    }
    @Override
    public List<Course> findAll() {
        return template.query("SELECT * FROM COURSE", this::rowMapper);
    }

    @Override
    public List<Course> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Course> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Course> findAllById(Iterable<Long> longs) {
//
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long id) {
        template.update("DELETE FROM COURSE WHERE ID = ?", new Object[]{id});
    }

    @Override
    public <S extends Course> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Course> findById(Long id) {
        Course c = template.queryForObject("SELECT COURSE WHERE ID = ?", new Object[]{id}, this::rowMapper);
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
    public <S extends Course> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Course> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Course> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Course getOne(Long aLong) {
        return null;
    }

    @Override
    public Course getById(Long id) {
        return findById(id).isPresent()? findById(id).get() : null;
    }

    @Override
    public Course getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Course> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Course> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Course> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Course> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Course> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Course> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Course, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    private Course rowMapper(ResultSet rs, int rownNum) throws SQLException {
        return new Course(rs.getLong("ID"), rs.getString("TITLE"),
                rs.getInt("DURATION"), rs.getString("COURSE_LEVEL"),
                rs.getString("DESCRIPTION"), rs.getLong("SECTOR_ID"));
    }

    @Override
    public void delete(Course c) {
        deleteById(c.getId());
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        for (Long id: longs) deleteById(id);
    }

    @Override
    public void deleteAll(Iterable<? extends Course> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Course save(Course c) {
        if (existsById(c.getId())){  //update
            template.update("UPDATE CLASSROOM (ID, TITLE, DURATION, COURSE_LEVEL, DESCRIPTION, SECTOR_ID)" +
                    " VALUES (?, ?, ?, ?, ?, ?)", getComponents(c));
        }
        else{   //save
            template.update("Insert INTO CLASSROOM ((ID, TITLE, DURATION, COURSE_LEVEL, DESCRIPTION, SECTOR_ID)" +
                    " VALUES (?, ?, ?, ?, ?, ?)", getComponents(c));
        }
        return c;
    }

    public Object[] getComponents(Course c){
        return new Object[]{ c.getId(), c.getTitle(), c.getDuration(), c.getCourseLevel(), c.getDescription(), c.getSectorId()};
    }
}
