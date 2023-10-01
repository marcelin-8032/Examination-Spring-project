package com.examination.project.infrastructure.handler.controller.v1.room;

import com.examination.project.domain.entities.Room;
import com.examination.project.domain.usecasesV1.room.RoomUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomRestHandler implements RoomHandler {

    @Autowired
    private RoomUseCase roomUseCase;

    @Override
    public ResponseEntity<Void> createARoom(Room room) {
        return roomUseCase.createRoom(room).fold(
                a -> ResponseEntity.badRequest().build(),
                room1 -> ResponseEntity.status(HttpStatus.CREATED).build()
        );
    }

    @Override
    public ResponseEntity<Void> updateRoomWithNumber(Integer roomId, int number) throws Exception {
        return roomUseCase.updateRoom(roomId, number).fold(
                a -> ResponseEntity.badRequest().build(),
                room2 -> ResponseEntity.status(HttpStatus.OK).build()
        );
    }

    @Override
    public ResponseEntity<Void> createTwoRoom(List<Room> rooms) {
        return roomUseCase.createTwoRooms(rooms).fold(
                a -> ResponseEntity.badRequest().build(),
                rooms1 -> ResponseEntity.status(HttpStatus.CREATED).build()
        );
    }

    @Override
    public ResponseEntity<Void> deleteAllRooms() {
        return roomUseCase.deleteAllRooms().fold(
                e -> ResponseEntity.notFound().build(),
                rooms -> new ResponseEntity<>(HttpStatus.OK)
        );
    }

}
