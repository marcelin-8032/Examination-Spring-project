package com.examination.project.infrastructure.persistance.student.entities;

import com.examination.project.domain.entities.Classe;
import com.examination.project.infrastructure.persistance.exam.entities.ExamEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Collection;
import java.util.HashSet;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "students")
public class StudentEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1478410950907668609L;

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;

    @Column(name = "student_name")
    private String firstName;

    @Column
    private String lastName;

    @Column
    private int identificationId;

    @Column
    private int studyYear;

    @Column
    private Instant birthDay;

    @Enumerated(EnumType.STRING)
    @Column(name = "classe")
    @Builder.Default
    private Classe classe = Classe.classeA;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "students_exams",
            joinColumns = {@JoinColumn(name = "student_entity_student_id")},
            inverseJoinColumns = {@JoinColumn(name = "exam_entity_exam_id")})
    @Builder.Default
    @ToString.Exclude
    private Collection<ExamEntity> examEntities = new HashSet<>();

    public void setExamEntities(Collection<ExamEntity> examEntities) {
        this.examEntities = examEntities;
    }

    public void addExam(ExamEntity examEntity) {
        this.examEntities.add(examEntity);
        examEntity.getStudents().add(this);
    }

}
