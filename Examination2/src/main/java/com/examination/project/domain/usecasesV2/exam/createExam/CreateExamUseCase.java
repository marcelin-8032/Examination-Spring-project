package com.examination.project.domain.usecasesV2.exam.createExam;

import com.examination.project.domain.exception.ExaminationException;
import com.examination.project.domain.usecasesV2.UseCaseAction;
import com.examination.project.domain.usecasesV2.exam.ExamUseCase;
import io.vavr.control.Either;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateExamUseCase implements ExamUseCase<CreateExamPort, CreateExamResult> {

    private final CreateExamStore createExamStore;

    @Override
    public UseCaseAction<?> action() {
        return ExamUseCaseAction.CREATE_EXAMS;
    }

    @Override
    public Either<ExaminationException, CreateExamResult> execute(CreateExamPort port) {
        return null;
    }


}
