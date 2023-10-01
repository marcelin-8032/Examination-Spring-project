package com.examination.project.domain.exception;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
public class ExaminationException extends Exception {

    @Getter
    private final CodeError code;

    public ExaminationException(CodeError code) {
        this.code = code;
    }


    public ExaminationException(String message, CodeError code) {
        super(message);
        this.code = code;
    }

    public ExaminationException(String message, Throwable cause, CodeError code) {
        super(message, cause);
        this.code = code;
    }
}
