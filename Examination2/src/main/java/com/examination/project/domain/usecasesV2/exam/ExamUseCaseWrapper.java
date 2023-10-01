package com.examination.project.domain.usecasesV2.exam;

import com.examination.project.domain.usecasesV2.UseCaseWrapper;
import com.examination.project.domain.usecasesV2.UseCase;

import java.util.Objects;
import java.util.Set;

import static com.examination.project.domain.usecasesV2.UseCase.*;

public class ExamUseCaseWrapper extends UseCaseWrapper {

    private ExamUseCaseWrapper(Set<? extends UseCase<Port, Result>> useCases) {
        super(useCases);
    }

    public static ExamUseCaseWrapper from(Set<ExamUseCase<Port, Result>> examUseCases) {

        Objects.requireNonNull(examUseCases);

        return new ExamUseCaseWrapper(examUseCases);
    }
}
