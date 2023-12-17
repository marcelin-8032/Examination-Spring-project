package com.examination.project.domain.usecases.v2.room;

import com.examination.project.domain.usecases.v2.UseCase.Port;
import com.examination.project.domain.usecases.v2.UseCase.Result;
import com.examination.project.domain.usecases.v2.UseCaseWrapper;

import java.util.Objects;
import java.util.Set;

public class RoomUseCaseWrapper extends UseCaseWrapper {

    protected RoomUseCaseWrapper(Set<RoomUseCase<Port, Result>> roomUseCases) {
        super(roomUseCases);
    }

    public static RoomUseCaseWrapper from(Set<RoomUseCase<Port, Result>> roomUseCases) {

        Objects.requireNonNull(roomUseCases);
        return new RoomUseCaseWrapper(roomUseCases);

    }


}
