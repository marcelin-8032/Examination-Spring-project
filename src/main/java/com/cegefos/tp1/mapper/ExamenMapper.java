package com.cegefos.tp1.mapper;

import com.cegefos.tp1.domains.Exam;
import com.cegefos.tp1.persistance.entities.ExamEntity;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface ExamenMapper {
    Exam toExamenDto(ExamEntity examEntity);
    ExamEntity toExamen(Exam exam);
    Collection<Exam> toExamenDtos(Collection<ExamEntity> examen);
    Collection<ExamEntity> toExamens(Collection<Exam> exams);

}
