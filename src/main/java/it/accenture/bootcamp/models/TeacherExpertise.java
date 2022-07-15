package it.accenture.bootcamp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TEACHER_EXPERTISE")
public class TeacherExpertise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "TEACHER", referencedColumnName = "ID")
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "SKILL", referencedColumnName = "ID")
    private Skill skill;
    @Column(name = "SKILL_LEVEL", nullable = false)
    private String skillLevel;

}