package com.examination.project.infrastructure.persistance.subject.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;

import com.examination.project.domain.entities.Module;

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

    private static final long serialVersionUID = -6377054955014203603L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer subjectId;

    @Column
    @NonNull
    private String title;

    @Column
    @NonNull
    private int coefficient;

    @Enumerated(EnumType.STRING)
    @Column
    @NonNull
    private Module module;

    @OneToMany
    @JoinColumn(name = "subject_id")
    private Collection<ExamEntity> examEntities = new HashSet<>();

}
