package com.examination.project.persistance.mapper;

import com.examination.project.domain.Exam;
import com.examination.project.persistance.entities.ExamEntity;
import org.mapstruct.Mapper;

import java.util.Collection;


@Mapper(componentModel = "spring")
public interface ExamMapper {
    Exam toExam(ExamEntity examEntity);
    ExamEntity toExam(Exam exam);
    Collection<Exam> toExams(Collection<ExamEntity> examEntities);
    Collection<ExamEntity> toExamEntities(Collection<Exam> exams);

}
