package com.cegefos.tp1.persistance.mapper;

import com.cegefos.tp1.domain.Exam;
import com.cegefos.tp1.persistance.entities.ExamEntity;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface ExamMapper {
    Exam toExamenDto(ExamEntity examEntity);
    ExamEntity toExamen(Exam exam);
    Collection<Exam> toExamenDtos(Collection<ExamEntity> examen);
    Collection<ExamEntity> toExamens(Collection<Exam> exams);

}
