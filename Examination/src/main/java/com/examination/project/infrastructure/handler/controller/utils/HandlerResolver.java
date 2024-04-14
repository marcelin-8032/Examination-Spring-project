package com.examination.project.infrastructure.handler.controller.utils;

import com.examination.project.domain.usecases.v2.UseCaseWrapper;
import com.examination.project.domain.exception.ExaminationException;

import java.util.function.Function;

import static com.examination.project.domain.usecases.v2.UseCase.*;

public abstract class HandlerResolver {

    private final UseCaseWrapper useCases;

    protected HandlerResolver(UseCaseWrapper useCases) {
        this.useCases = useCases;
    }

    protected Result execute(Port port) throws ExaminationException {
        return this.useCases.execute(port).getOrElseThrow(Function.identity());
    }
}
