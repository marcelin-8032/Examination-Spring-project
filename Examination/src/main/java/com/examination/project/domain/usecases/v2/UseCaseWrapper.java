package com.examination.project.domain.usecases.v2;

import com.examination.project.domain.exception.ExaminationException;
import io.vavr.control.Either;

import java.util.Map;
import java.util.Set;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public abstract class UseCaseWrapper {
    private final Map<UseCaseAction<?>, UseCase<UseCase.Port, UseCase.Result>> useCases;
    protected UseCaseWrapper(Set<? extends UseCase<UseCase.Port, UseCase.Result>> useCases) {
        this.useCases = init(useCases);
    }
    public Either<ExaminationException, UseCase.Result> execute(UseCase.Port port) {

        final UseCase<UseCase.Port, UseCase.Result> useCase = this.useCases.computeIfAbsent(port.action(), key -> {
            throw new UnsupportedOperationException(key + " not found");
        });

        return useCase.execute(port);
    }

    private Map<UseCaseAction<?>, UseCase<UseCase.Port, UseCase.Result>> init(Set<? extends UseCase<UseCase.Port, UseCase.Result>> useCases) {

        return useCases.stream().collect(toMap(UseCase::action, identity()));
    }
}
