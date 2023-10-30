package com.examination.project.domain.exception;

public class UnknownErrorException extends ExaminationException{

    public UnknownErrorException(CodeError code) {
        super(code);
    }

    public UnknownErrorException(String message, CodeError code) {
        super(message, code);
    }

    public UnknownErrorException(String message, Throwable cause, CodeError code) {
        super(message, cause, code);
    }
}
