package com.examination.project.persistance.student.entities;

import java.io.Serializable;


import javax.persistence.*;

import com.examination.project.enums.Classe;

import com.examination.project.persistance.exam.entities.ExamEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "etudiants")
public class StudentEntity implements Serializable {

    private static final long serialVersionUID = 1478410950907668609L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer etudiantId;

    @Column
    private String nom;

    @Enumerated(EnumType.STRING)
    @Column
    private Classe classe;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "etudiants_examens", joinColumns = {@JoinColumn(name = "examen_id")}, inverseJoinColumns = {
            @JoinColumn(name = "etudiant_id")})
    private Set<ExamEntity> examEntities =HashSet.empty();

    public StudentEntity(String nom, Classe classe, Set<ExamEntity> examEntities) {
        this.nom = nom;
        this.classe = classe;
        this.examEntities = examEntities;
    }
}
