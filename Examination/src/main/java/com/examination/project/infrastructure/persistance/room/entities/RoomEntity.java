package com.examination.project.infrastructure.persistance.room.entities;


import javax.persistence.*;


import com.examination.project.infrastructure.persistance.common.audit.AuditableBaseEntity;
import com.examination.project.infrastructure.persistance.exam.entities.ExamEntity;
import lombok.*;

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

    @OneToMany()
    @JoinColumn(name = "room_id")
    @Builder.Default
    private Collection<ExamEntity> examEntities = new HashSet<>();

    public void setExamEntities(Collection<ExamEntity> examEntities) {
        this.examEntities.addAll(examEntities);
    }

    // Audit by annotation
 /*    @CreatedBy
     @Column
     private User createdBy;

     @CreatedDate
     @Column
     private ZonedDateTime createdAt;

     @LastModifiedBy
     @Column private User updatedBy;

     @LastModifiedDate
     @Column
     private ZonedDateTime updatedAt;*/
}
