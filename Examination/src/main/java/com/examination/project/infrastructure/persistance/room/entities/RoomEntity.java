package com.examination.project.infrastructure.persistance.room.entities;


import com.examination.project.infrastructure.persistance.common.audit.AuditableBaseEntity;
import com.examination.project.infrastructure.persistance.exam.entities.ExamEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Collection;
import java.util.HashSet;


@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Builder(toBuilder = true)
@Table(name = "rooms")
public class RoomEntity extends AuditableBaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1709421529408867178L;

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roomId;

    @Column
    @NonNull
    private int number;

/*    @Column
    @CreatedDate
    private Instant createDate;

    @Column
    @CreatedBy
    private String createdBy;

    @Column
    @LastModifiedDate
    private Instant modifiedDate;

    @Column
    @LastModifiedBy
    private String modifiedBy;*/

    @Column
    private String building;

    @Column
    private String department;

    @Column
    private int floor;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Collection<ExamEntity> examEntities = new HashSet<>();

    public void setExamEntities(Collection<ExamEntity> examEntities) {
        this.examEntities.addAll(examEntities);
    }
}
