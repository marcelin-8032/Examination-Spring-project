package com.examination.project.infrastructure.handler.utils;


import com.examination.project.domain.exception.ExaminationException;
import io.vavr.control.Either;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static io.vavr.API.run;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EitherTools {

    public static Void doNothing() {
        return run(() -> {
        });
    }

    public static Either<ExaminationException, Void> nothing() {
        return Either.right(null);
    }

    public static <T> Either<ExaminationException, T> error(ExaminationException e) {
        return Either.left(e);
    }
}
