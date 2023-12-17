package com.examination.project.domain.exception;


import lombok.EqualsAndHashCode;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

@EqualsAndHashCode(callSuper = true)
public class IntegrityConstraintException extends ExaminationException {

    private static final BiFunction<CodeError, List<Object>, String> ERROR_MESSAGE =
            (e, l) -> new MessageFormat("Validation constraint on {0} with these parameters: {1}")
                    .format(new Object[]{
                            e.reason(), l
                    });

    public IntegrityConstraintException(CodeError code, Object... params) {
        super(ERROR_MESSAGE.apply(code, Arrays.asList(params)), code);
    }
}
