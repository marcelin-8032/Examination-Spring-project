package com.examination.project.usecases.room;

import java.util.List;

import com.examination.project.entities.Room;

public interface RoomUseCase {

	void createRoom(Room room);
	
	void deleteAllRooms();
	
	void updateRoom(Integer id, int numero) throws Exception;
	
	void createTwoRooms(List<Room> rooms);
}
