package com.examination.project.domain.usecases.v2.room;

import com.examination.project.domain.usecases.v2.UseCase;
import com.examination.project.domain.usecases.v2.UseCase.Port;
import com.examination.project.domain.usecases.v2.UseCase.Result;
import com.examination.project.domain.usecases.v2.UseCaseAction;

public interface RoomUseCase<P extends Port, R extends Result> extends UseCase<P,R> {

    enum RoomUseCaseAction implements UseCaseAction<RoomUseCaseAction>{

        CREATE_ROOM,

        CREATE_TWO_ROOM,

        DELETE_ALL_ROOMS,

        FIND_ALL_ROOMS,
    }
}
