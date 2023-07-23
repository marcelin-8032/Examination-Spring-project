package com.examination.project.handler.persistance.student.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;


import javax.persistence.*;

import com.examination.project.entities.Classe;
import com.examination.project.handler.persistance.exam.entities.ExamEntity;

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

    private static final long serialVersionUID = 1478410950907668609L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;

    @Column
    private String nom;

    @Enumerated(EnumType.STRING)
    @Column
    private Classe classe;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = ExamEntity.class, cascade = CascadeType.ALL)
    private Collection<ExamEntity> examEntities =new HashSet<>();

    public StudentEntity(String nom, Classe classe, Set<ExamEntity> examEntities) {
        this.nom = nom;
        this.classe = classe;
        this.examEntities = (Collection<ExamEntity>) examEntities;
    }
}
