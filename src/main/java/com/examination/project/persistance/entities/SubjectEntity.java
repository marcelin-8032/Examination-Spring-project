package com.examination.project.persistance.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.examination.project.enums.Module;

import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import lombok.*;


@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Builder(toBuilder = true)
@Table(name = "matiere")
public class SubjectEntity implements Serializable {

    private static final long serialVersionUID = -6377054955014203603L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer matiereId;

    @Column
    @NonNull
    private String intitule;

    @Column
    @NonNull
    private int coefficient;

    @Enumerated(EnumType.STRING)
    @Column
    @NonNull
    private Module module;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "matiere")
    private Set<ExamEntity> examenEntities = HashSet.empty();

}