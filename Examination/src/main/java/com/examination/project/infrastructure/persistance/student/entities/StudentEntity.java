package com.examination.project.infrastructure.persistance.student.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;


import javax.persistence.*;

import com.examination.project.domain.entities.Classe;
import com.examination.project.infrastructure.persistance.exam.entities.ExamEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.vavr.collection.Set;
import lombok.*;

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
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer studentId;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    @Column
    private Classe classe;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = ExamEntity.class, cascade = CascadeType.ALL)
    private Collection<ExamEntity> examEntities =new HashSet<>();

    public StudentEntity(String name, Classe classe, Set<ExamEntity> examEntities) {
        this.name= name;
        this.classe = classe;
        this.examEntities = (Collection<ExamEntity>) examEntities;
    }
}
