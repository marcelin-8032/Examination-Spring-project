package com.cegefos.tp1.domain;

import com.cegefos.tp1.persistance.entities.StudentEntity;
import com.cegefos.tp1.persistance.entities.SubjectEntity;
import com.cegefos.tp1.persistance.entities.RoomEntity;
import com.cegefos.tp1.persistance.entities.InvigilatorEntity;
import lombok.Builder;
import lombok.With;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;


@Builder
@With
public record Exam(Integer examenId,
                   LocalDateTime dateExam,
                   Set<StudentEntity> etudiantEntities,
                   SubjectEntity subjectEntity,
                   RoomEntity roomEntity,
                   InvigilatorEntity invigilatorEntity) implements Serializable {

}
