package it.accenture.bootcamp.mappers;

import it.accenture.bootcamp.dtos.CourseDTO;
import it.accenture.bootcamp.models.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    @Mapping(source = "sector.id", target = "sectorId")
    @Mapping(source = "sector.name", target = "sectorName")
    CourseDTO toCourseDto(Course course);

    Course toCourse(CourseDTO courseDto);
}
