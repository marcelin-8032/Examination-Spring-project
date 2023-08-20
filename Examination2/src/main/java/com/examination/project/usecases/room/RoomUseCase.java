package com.examination.project.usecases.room;


import com.examination.project.entities.Room;
import com.examination.project.exception.ExaminationException;
import io.vavr.control.Either;

import java.util.Collection;

public interface RoomUseCase {

	Either<ExaminationException, Room> createRoom(Room room);
	Either<ExaminationException, Void> deleteAllRooms();
	Either<ExaminationException, Void> updateRoom(Integer id, int numero) throws Exception;
	Either<ExaminationException, Void> createTwoRooms(Collection<Room> rooms);
}
