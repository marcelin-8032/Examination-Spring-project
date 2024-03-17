package com.examination.project.utils.functional;


import com.examination.project.domain.exception.ExaminationException;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class OptionUtils {

    public static <T, R> Either<ExaminationException, R> toEither(Option<T> o, Supplier<ExaminationException> l, Function<T, R> r) {

        List.of(o, l, r).forEach(Objects::requireNonNull);

        return o.map(r).toEither(l);
    }

    public static <T, X extends Throwable> void onPresentThrow(Option<T> o, Supplier<X> exceptionSupplier) throws X {

        List.of(o, exceptionSupplier).forEach(Objects::requireNonNull);

        if (o.isDefined()) {
            throw exceptionSupplier.get();
        }
    }


}
