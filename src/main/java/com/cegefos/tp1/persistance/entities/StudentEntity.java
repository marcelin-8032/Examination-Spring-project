package com.cegefos.tp1.persistance.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.cegefos.tp1.enums.Classe;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Set<ExamEntity> examenEntities = new HashSet<>();


    public StudentEntity(@NonNull String nom, @NonNull Classe classe, @NonNull Set<ExamEntity> examenEntities) {
        this.nom = nom;
        this.classe = classe;
        this.examenEntities = examenEntities;
    }
}
