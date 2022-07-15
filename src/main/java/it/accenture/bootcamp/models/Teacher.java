package it.accenture.bootcamp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TEACHER")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "SURNAME", nullable = false)
    private String surname;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "BDATE", nullable = false)
    private LocalDate bdate;
    @Column(name = "EMAIL", nullable = false)
    private String email;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "ADDRESS", nullable = false)
    private String address;
    @Column(name = "P_IVA")
    private String pIva;

    @OneToMany(mappedBy = "teacher")
    private List<TeachingAssignment> teachingAssignments;
    @OneToMany(mappedBy = "teacher")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<TeacherExpertise> teacherExpertises;
}