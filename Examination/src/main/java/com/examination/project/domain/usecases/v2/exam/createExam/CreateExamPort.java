package com.examination.project.domain.usecases.v2.exam.createExam;

import com.examination.project.domain.usecases.v2.UseCase;
import com.examination.project.domain.usecases.v2.UseCaseAction;
import com.examination.project.domain.usecases.v2.exam.ExamUseCase;

import static com.examination.project.domain.usecases.v2.exam.ExamUseCase.ExamUseCaseAction.CREATE_EXAMS;

public record CreateExamPort() implements UseCase.Port {
    @Override
    public UseCaseAction<ExamUseCase.ExamUseCaseAction> action() {
        return CREATE_EXAMS;
    }
}
