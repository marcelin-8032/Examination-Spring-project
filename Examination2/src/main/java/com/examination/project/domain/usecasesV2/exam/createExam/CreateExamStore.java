package com.examination.project.domain.usecasesV2.exam.createExam;

import com.examination.project.domain.entities.Exam;
import com.examination.project.domain.exception.ExaminationException;
import io.vavr.control.Either;

import java.util.Collection;
import java.util.List;

public interface CreateExamStore {

    Either<ExaminationException, Collection<Exam>> createExams(List<Exam> exams);

}
