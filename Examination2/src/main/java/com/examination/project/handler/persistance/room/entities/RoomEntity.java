package com.examination.project.handler.persistance.room.entities;


import javax.persistence.*;


import com.examination.project.handler.persistance.common.audit.AuditableBaseEntity;
import com.examination.project.handler.persistance.exam.entities.ExamEntity;
import lombok.*;

import java.util.Collection;
import java.util.HashSet;


@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Builder(toBuilder = true)
@Table(name = "room")
public class RoomEntity extends AuditableBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roomId;

    @Column
    @NonNull
    private int numero;

    @OneToMany
	@JoinColumn(name = "room_id")
    private Collection<ExamEntity> examEntities = new HashSet<>();

    // Audit by annotation
    /*
     * @CreatedBy
     *
     * @Column private User createdBy;
     *
     * @CreatedDate
     *
     * @Column private ZonedDateTime createdAt;
     *
     * @LastModifiedBy
     *
     * @Column private User updatedBy;
     *
     * @LastModifiedDate
     *
     * @Column private ZonedDateTime updatedAt;
     */

}
