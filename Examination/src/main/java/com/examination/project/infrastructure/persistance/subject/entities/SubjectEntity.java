package com.examination.project.infrastructure.persistance.subject.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;

import com.examination.project.domain.entities.SubjectModule;

import com.examination.project.infrastructure.persistance.exam.entities.ExamEntity;

import lombok.*;


@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Builder(toBuilder = true)
@Table(name = "subject")
public class SubjectEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -6377054955014203603L;

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer subjectId;

    @Column
    @NonNull
    private String title;

    @Column
    @NonNull
    private int coefficient;

    @Enumerated(EnumType.STRING)
    @Column(name = "subject_module")
    @NonNull
    private SubjectModule subjectModule;

    @OneToMany
    @JoinColumn(name = "subject_id")
    private Collection<ExamEntity> examEntities = new HashSet<>();

}
