package com.examination.project.infrastructure.persistance.subject.entities;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;

import com.examination.project.domain.entities.SubjectModule;

import com.examination.project.infrastructure.persistance.exam.entities.ExamEntity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;


@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Builder(toBuilder = true)
@Table(name = "subjects")
public class SubjectEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -6377054955014203603L;

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int subjectId;

    @Column
    @NonNull
    private String title;

    @Column
    @NonNull
    private int coefficient;

    @Column
    @CreatedDate
    private LocalDateTime createDate;

    @Column
    @CreatedBy
    private String createdBy;

    @Column
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Column
    @LastModifiedBy
    private String modifiedBy;

    @Column(name = "subject_module")
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private SubjectModule subjectModule = SubjectModule.MODULE_1;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    @Builder.Default
    private Collection<ExamEntity> examEntities = new HashSet<>();

    public void setExamEntities(Collection<ExamEntity> examEntities) {
        this.examEntities.addAll(examEntities);
    }
}
