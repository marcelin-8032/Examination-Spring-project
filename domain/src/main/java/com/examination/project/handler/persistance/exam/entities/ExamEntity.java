package com.examination.project.handler.persistance.exam.entities;

import com.examination.project.handler.persistance.invigilator.entities.InvigilatorEntity;
import com.examination.project.handler.persistance.room.entities.RoomEntity;
import com.examination.project.handler.persistance.student.entities.StudentEntity;
import com.examination.project.handler.persistance.subject.entities.SubjectEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import lombok.*;

import javax.persistence.*;
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

    private static final long serialVersionUID = 6958515320559275010L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer examId;

    @Column
    @NonNull
    private LocalDateTime dateExam;

    @ManyToMany(mappedBy = "exams")
    @NonNull
    private Set<StudentEntity> studentEntities = HashSet.empty();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "subject_id")
    @NonNull
    private SubjectEntity subjectEntity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "room_id")
    @NonNull
    private RoomEntity roomEntity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "invigilator_id")
    @NonNull
    private InvigilatorEntity invigilatorEntity;

}
