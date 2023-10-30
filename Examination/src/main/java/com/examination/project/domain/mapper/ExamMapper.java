package com.examination.project.domain.mapper;


import com.examination.project.domain.entities.Exam;
import com.examination.project.infrastructure.persistance.exam.entities.ExamEntity;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Collection;
import java.util.List;


@Mapper(componentModel = "spring")
public interface ExamMapper {
    Exam toExam(ExamEntity examEntity);

    ExamEntity toExamEntity(Exam exam);

    Collection<Exam> toExams(Collection<ExamEntity> examEntities);

    Collection<ExamEntity> toExamEntities(Collection<Exam> exams);

    default Page<Exam> pageExamEntityToPageExamDto(Page<ExamEntity> page) {
        List<Exam> examList = (List<Exam>) toExams(page.getContent());
        return new PageImpl(examList, page.getPageable(), page.getTotalElements());
    }

}
