package com.examination.project.domain.usecases.v2.room.createroom;

import com.examination.project.domain.usecases.v2.UseCase.Port;
import com.examination.project.domain.usecases.v2.UseCaseAction;
import com.examination.project.domain.usecases.v2.room.RoomUseCase.RoomUseCaseAction;

import static com.examination.project.domain.usecases.v2.room.RoomUseCase.RoomUseCaseAction.CREATE_ROOM;

public record CreateRoomPort() implements Port {

    @Override
    public UseCaseAction<RoomUseCaseAction> action() {
        return CREATE_ROOM;
    }
}
