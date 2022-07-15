package it.accenture.bootcamp.dtos;

import it.accenture.bootcamp.models.Edition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EditionDTO {
    private Long id;
    private String startDate;
    private String endDate;
    private long courseId;
    private String courseTitle;

    // public static EditionDTO fromEdition(Edition e) {
    // return new EditionDTO(e.getId(), e.getStartDate().toString(),
    // e.getEndDate().toString(), e.getCourse().getId(),
    // e.getCourse().getTitle());
    // }
}