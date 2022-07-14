package it.accenture.bootcamp.dtos;

import it.accenture.bootcamp.models.Classroom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomDTO {
    private Long id;
    private String name;
    private Integer capacity;
    private String software;
    private Boolean hasProjector;
    private Boolean hasMainPc;
    private Boolean isComputerized;
    private boolean isVirtual;

    public static ClassroomDTO fromClassroom(Classroom c) {
        return new ClassroomDTO(c.getId(), c.getName(), c.getCapacity(), c.getSoftware(), c.getHasProjector(),
                c.getHasMainPc(), c.getIsComputerized(), c.isVirtual());
    }

    public Classroom toClassroom() {
        return new Classroom(this.id, this.name, this.capacity, this.software, this.hasProjector, this.hasMainPc,
                this.isComputerized, this.isVirtual());
    }

}
