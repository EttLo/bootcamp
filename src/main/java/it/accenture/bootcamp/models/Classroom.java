package it.accenture.bootcamp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Classroom implements WithId<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CAPACITY")
    private Integer capacity;
    @Column(name = "SOFTWARE")
    private String software;
    @Column(name = "PROJECTOR")
    private Boolean hasProjector;
    @Column(name = "MAIN_PC")
    private Boolean hasMainPc;
    @Column(name = "IS_COMPUTERIZED")
    private Boolean isComputerized;
    @Column(name = "IS_VIRTUAL")
    private boolean isVirtual;

}
