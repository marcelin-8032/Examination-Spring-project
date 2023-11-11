package com.examination.project.infrastructure.handler.controller.v1.room;

import com.examination.project.domain.entities.Room;
import com.examination.project.domain.usecases.v1.room.RoomUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/" + "rooms")
@RequiredArgsConstructor
public class RoomRestHandler implements RoomHandler {

    private final RoomUseCase roomUseCase;

    @Override
    @PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createARoom(@RequestBody Room room) {
        return roomUseCase.createRoom(room).fold(
                a -> ResponseEntity.badRequest().build(),
                room1 -> ResponseEntity.status(HttpStatus.CREATED).build()
        );
    }

    @Override
    @PutMapping(value = "/update/{roomId}", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateRoomWithNumber(@PathVariable("roomId") Integer roomId, int number) throws Exception {
        return roomUseCase.updateRoom(roomId, number).fold(
                a -> ResponseEntity.badRequest().build(),
                room2 -> ResponseEntity.status(HttpStatus.OK).build()
        );
    }

    @Override
    @PostMapping
    public ResponseEntity<Void> createTwoRoom(@RequestBody List<Room> rooms) {
        return roomUseCase.createTwoRooms(rooms).fold(
                a -> ResponseEntity.badRequest().build(),
                rooms1 -> ResponseEntity.status(HttpStatus.CREATED).build()
        );
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Void> deleteAllRooms() {
        return roomUseCase.deleteAllRooms().fold(
                e -> ResponseEntity.notFound().build(),
                rooms -> new ResponseEntity<>(HttpStatus.OK)
        );
    }

}
