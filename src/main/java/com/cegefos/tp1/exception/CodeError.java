package com.cegefos.tp1.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

import static lombok.AccessLevel.PRIVATE;

@Accessors(fluent = true)
@AllArgsConstructor(access = PRIVATE)
public enum CodeError {

    STUDENT_NOT_FOUND("Student not found"),

    UNKNOWN_ERROR("Unknown error");

    @Getter
    private final String reason;
}
