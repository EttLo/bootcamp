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

    @Mapping(source = "sectorId", target = "sector.id")
    @Mapping(source = "sectorName", target = "sector.name")
    Course toCourse(CourseDTO courseDto);
}
