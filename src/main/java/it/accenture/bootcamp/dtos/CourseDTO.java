package it.accenture.bootcamp.dtos;

import it.accenture.bootcamp.models.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private Long id;
    private String title;
    private Integer duration;
    private String courseLevel;
    private String description;
    private long sectorId;
    private String sectorName;

    // public static CourseDTO fromCourse(Course c) {
    // return new CourseDTO(c.getId(), c.getTitle(), c.getDuration(),
    // c.getCourseLevel(), c.getDescription(),
    // c.getSectorId());
    // }

    // public Course toCourse() {
    // return new Course(this.getId(), this.getTitle(), this.getDuration(),
    // this.getCourseLevel(),
    // this.getDescription(), this.getSectorId());
    // }
}
