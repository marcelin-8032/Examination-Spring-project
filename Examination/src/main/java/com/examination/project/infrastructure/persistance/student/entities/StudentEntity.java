package com.examination.project.infrastructure.persistance.student.entities;

import com.examination.project.domain.entities.Classe;
import com.examination.project.infrastructure.persistance.exam.entities.ExamEntity;
import io.vavr.collection.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
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
    private Integer studentId;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "classe")
    @Builder.Default
    private Classe classe = Classe.classeA;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = ExamEntity.class, cascade = CascadeType.ALL)
    private Collection<ExamEntity> examEntities = new HashSet<>();

    public StudentEntity(String name, Classe classe, Set<ExamEntity> examEntities) {
        this.name = name;
        this.classe = classe;
        this.examEntities = (Collection<ExamEntity>) examEntities;
    }
}
