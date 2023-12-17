package com.examination.project.domain.usecases.v2.room.createroom;

import com.examination.project.domain.entities.Room;
import com.examination.project.domain.exception.ExaminationException;
import io.vavr.control.Either;

import java.util.function.Consumer;

public interface CreateRoomStore {

    Either<ExaminationException, Room> createRoom(Room room);

    Room unSafeCreateRoom(Room room) throws ExaminationException;

    Room unSafeCreateRoom(Consumer<Room> binding) throws ExaminationException;

    Room unSafeCreateRoom() throws ExaminationException;

}
