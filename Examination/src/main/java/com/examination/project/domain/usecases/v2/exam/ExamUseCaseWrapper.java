package com.examination.project.domain.usecases.v2.exam;

import com.examination.project.domain.usecases.v2.UseCase;
import com.examination.project.domain.usecases.v2.UseCaseWrapper;

import java.util.Objects;
import java.util.Set;

public class ExamUseCaseWrapper extends UseCaseWrapper {

    private ExamUseCaseWrapper(Set<? extends UseCase<UseCase.Port, UseCase.Result>> useCases) {
        super(useCases);
    }

    public static ExamUseCaseWrapper from(Set<ExamUseCase<UseCase.Port, UseCase.Result>> examUseCases) {

        Objects.requireNonNull(examUseCases);

        return new ExamUseCaseWrapper(examUseCases);
    }
}
