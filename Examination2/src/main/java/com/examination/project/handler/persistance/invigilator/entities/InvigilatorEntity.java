package com.examination.project.handler.persistance.invigilator.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;


import com.examination.project.handler.persistance.exam.entities.ExamEntity;
import lombok.*;


@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Builder(toBuilder = true)
@Table(name = "invigilator")
public class InvigilatorEntity implements Serializable {

    private static final long serialVersionUID = -5461477499521864156L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer invigilatorId;

    @Column
    @NonNull
    private String nom;

    @OneToMany
    @JoinColumn(name = "invigilator_id")
    private Collection<ExamEntity> examEntities = new HashSet<>();

}
