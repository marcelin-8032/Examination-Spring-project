package com.examination.project.domain.usecasesV2;

import com.examination.project.domain.exception.ExaminationException;
import io.vavr.control.Either;

public interface UseCase<P extends UseCase.Port, R extends UseCase.Result> {

    UseCaseAction<?> action();

    Either<ExaminationException, R> execute(P port);

    interface Port {
        UseCaseAction<?> action();
    }

    interface Result {
        Object data();
    }
}
