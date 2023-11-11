package com.examination.project.infrastructure.persistance.exam.entities;

import com.examination.project.infrastructure.persistance.invigilator.entities.InvigilatorEntity;
import com.examination.project.infrastructure.persistance.subject.entities.SubjectEntity;
import com.examination.project.infrastructure.persistance.room.entities.RoomEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "exams")
public class ExamEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 6958515320559275010L;

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer examId;

    @Column
    private String examName;

    @Column
    @NonNull
    private LocalDateTime examDate;

    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id", nullable = false)
    @NonNull
    private SubjectEntity subject;

    @ManyToOne(optional = false)
    @JoinColumn(name = "room_id", nullable = false)
    @NonNull
    private RoomEntity room;

    @ManyToOne(optional = false)
    @JoinColumn(name = "invigilator_id", nullable = false)
    @NonNull
    private InvigilatorEntity invigilator;
}
