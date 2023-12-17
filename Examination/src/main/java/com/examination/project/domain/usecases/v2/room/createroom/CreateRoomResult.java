package com.examination.project.domain.usecases.v2.room.createroom;

import com.examination.project.domain.entities.Room;
import com.examination.project.domain.usecases.v2.UseCase;

public record CreateRoomResult(Room roomData) implements UseCase.Result {

    @Override
    public Object data() {
        return null;
    }
}
