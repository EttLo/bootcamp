package it.accenture.bootcamp.mappers;

import it.accenture.bootcamp.dtos.ClassroomDTO;
import it.accenture.bootcamp.models.Classroom;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClassroomMapper {
    ClassroomMapper INSTANCE = Mappers.getMapper(ClassroomMapper.class);

    ClassroomDTO toClassroomDto(Classroom classroom);

    Classroom toClassroom(ClassroomDTO classroomDto);
}
