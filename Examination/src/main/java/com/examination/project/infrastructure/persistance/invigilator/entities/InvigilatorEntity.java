package com.examination.project.infrastructure.persistance.invigilator.entities;

import com.examination.project.infrastructure.persistance.exam.entities.ExamEntity;
import lombok.*;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;


@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Builder(toBuilder = true)
@Table(name = "invigilators")
public class InvigilatorEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -5461477499521864156L;

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int invigilatorId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    @NonNull
    private int identificationNumber;

    @OneToMany
    @JoinColumn(name = "invigilator_id")
    @Builder.Default
    private Collection<ExamEntity> examEntities = new HashSet<>();

    public void setExamEntities(Collection<ExamEntity> examEntities) {
        this.examEntities.addAll(examEntities);
    }

}
