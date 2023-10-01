package com.examination.project.domain.usecasesV2;

import com.examination.project.domain.exception.ExaminationException;
import com.examination.project.domain.usecasesV2.UseCase;
import com.examination.project.domain.usecasesV2.UseCase.Result;
import com.examination.project.domain.usecasesV2.UseCase.Port;
import com.examination.project.domain.usecasesV2.UseCaseAction;
import io.vavr.control.Either;

import java.util.Map;
import java.util.Set;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public abstract class UseCaseWrapper {
    private final Map<UseCaseAction<?>, UseCase<Port, Result>> useCases;
    protected UseCaseWrapper(Set<? extends UseCase<UseCase.Port, Result>> useCases) {
        this.useCases = init(useCases);
    }
    public Either<ExaminationException, Result> execute(Port port) {

        final UseCase<Port, Result> useCase = this.useCases.computeIfAbsent(port.action(), key -> {
            throw new UnsupportedOperationException(key + " not found");
        });

        return useCase.execute(port);
    }

    private Map<UseCaseAction<?>, UseCase<Port, Result>> init(Set<? extends UseCase<Port, Result>> useCases) {

        return useCases.stream().collect(toMap(UseCase::action, identity()));
    }
}
