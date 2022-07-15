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
@Table(name = "TEACHING_ASSIGNMENT")
public class TeachingAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "TEACHER", referencedColumnName = "ID")
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "MODULE", referencedColumnName = "ID")
    private Module module;
    @Column(name = "DESCRIPTION")
    private String description;
}