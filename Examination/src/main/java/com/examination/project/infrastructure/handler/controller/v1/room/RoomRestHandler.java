package com.examination.project.infrastructure.handler.controller.v1.room;

import com.examination.project.domain.entities.Room;
import com.examination.project.domain.usecases.v1.room.RoomUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/v1/" + "rooms")
@RequiredArgsConstructor
public class RoomRestHandler implements RoomHandler {

    private final RoomUseCase roomUseCase;

    @Override
    @PostMapping(value = "/create")
    public ResponseEntity<Void> createARoom(@RequestBody Room room) {
        return roomUseCase.createRoom(room).fold(
                a -> ResponseEntity.badRequest().build(),
                room1 -> ResponseEntity.status(HttpStatus.CREATED).build()
        );
    }

    @Override
    @PutMapping(value = "/update/{roomId}")
    public ResponseEntity<Void> updateRoomNumber(@PathVariable("roomId") Integer roomId, int number) throws Exception {
        return roomUseCase.updateRoom(roomId, number).fold(
                a -> ResponseEntity.badRequest().build(),
                room2 -> ResponseEntity.status(HttpStatus.OK).build()
        );
    }

    @Override
    @PostMapping(value = "createSeveralRooms")
    public ResponseEntity<Void> addSeveralRooms(@RequestBody List<Room> rooms) {
        return roomUseCase.createSeveralRooms(rooms).fold(
                a -> ResponseEntity.badRequest().build(),
                rooms1 -> ResponseEntity.status(HttpStatus.CREATED).build()
        );
    }

    @Override
    @GetMapping
    public ResponseEntity<Collection<Room>> fetchAllRooms() {
        return roomUseCase.getAllRooms().fold(
                a->ResponseEntity.notFound().build(),
                ResponseEntity::ok
        );
    }

    @Override
    @DeleteMapping(value = "/deleteAll")
    public ResponseEntity<Void> deleteAllRooms() {
        return roomUseCase.deleteAllRooms().fold(
                e -> ResponseEntity.notFound().build(),
                room2 -> ResponseEntity.status(HttpStatus.OK).build()
        );
    }
}
