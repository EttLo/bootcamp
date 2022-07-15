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
@Table(name = "STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "SURNAME", nullable = false)
    private String surname;
    @Column(name = "BDATE", nullable = false)
    private LocalDate bdate;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "EMAIL", nullable = false)
    private String email;
    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;
    @OneToMany(mappedBy = "student") // punta la variabile nell'altra classe
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<StudentExpertise> studentExpertises;
}