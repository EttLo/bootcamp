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
@Table(name = "STUDENT_FEEDBACK")
public class StudentFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "TEACHING_ASSIGNMENT", referencedColumnName = "ID")
    private TeachingAssignment teachingAssignment;
    @ManyToOne
    @JoinColumn(name = "STUDENT", referencedColumnName = "ID")
    private Student student;
    @Column(name = "GRADE", nullable = false)
    private int grade;
    @Column(name = "FEEDBACK", nullable = false)
    private String feedback;

}