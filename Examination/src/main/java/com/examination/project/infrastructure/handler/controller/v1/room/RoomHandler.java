package com.examination.project.infrastructure.handler.controller.v1.room;

import com.examination.project.domain.entities.Room;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface RoomHandler {

    ResponseEntity<Void> createARoom(Room room);

    ResponseEntity<Void> updateRoomWithNumber( Integer salleId, int numero) throws Exception;

    ResponseEntity<Void> createTwoRoom( List<Room> rooms);

    ResponseEntity<Void> deleteAllRooms();
}
