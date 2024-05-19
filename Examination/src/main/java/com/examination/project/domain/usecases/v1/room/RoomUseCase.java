package com.examination.project.domain.usecases.v1.room;


import com.examination.project.domain.entities.Room;
import com.examination.project.domain.exception.ExaminationException;
import io.vavr.control.Either;

import java.util.Collection;

public interface RoomUseCase {

    Either<ExaminationException, Room> createRoom(Room room);

    Either<ExaminationException, Void> createSeveralRooms(Collection<Room> rooms);

    Either<ExaminationException, Void> updateRoom(Integer id, int number) throws Exception;

    Either<ExaminationException, Collection<Room>> getAllRooms();

    Either<ExaminationException, Void> deleteAllRooms();
}
