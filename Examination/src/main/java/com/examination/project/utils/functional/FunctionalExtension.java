package com.examination.project.utils.functional;


import com.examination.project.domain.exception.ExaminationException;
import io.vavr.control.Either;
import lombok.NoArgsConstructor;

import static io.vavr.API.run;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class FunctionalExtension {

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
