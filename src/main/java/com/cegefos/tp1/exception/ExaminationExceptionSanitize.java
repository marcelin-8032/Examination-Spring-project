package com.cegefos.tp1.exception;




import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.cegefos.tp1.exception.CodeError.UNKNOWN_ERROR;
import static io.vavr.API.*;
import static io.vavr.Predicates.instanceOf;
import static io.vavr.Predicates.isNotNull;
import static java.util.function.Function.identity;
import static lombok.AccessLevel.PRIVATE;

@Slf4j
@NoArgsConstructor(access = PRIVATE)
public class ExaminationExceptionSanitize {

    public static ExaminationException sanitizeError(final Throwable throwable){

        return Match(throwable).of(
                Case($(instanceOf(ExaminationException.class)),identity()),
                Case($(isNotNull()),e-> new UnknownErrorException(e.getMessage(), e, UNKNOWN_ERROR)),
                Case($(),e->new UnknownErrorException("", e, UNKNOWN_ERROR)));
    }

}
