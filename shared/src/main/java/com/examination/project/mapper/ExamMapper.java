package com.examination.project.mapper;


import com.examination.project.entities.Exam;
import com.examination.project.persistance.exam.entities.ExamEntity;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;


@Mapper(componentModel = "spring")
public interface ExamMapper {
    Exam toExam(ExamEntity examEntity);
    ExamEntity toExamEntity(Exam exam);
    Collection<Exam> toExams(Collection<ExamEntity> examEntities);
    Collection<ExamEntity> toExamEntities(Collection<Exam> exams);
    Page<Exam> toExamPage(Page<ExamEntity> examEntityPage);

}
