package com.examination.project.infrastructure.handler.controller.v1.room;

import com.examination.project.domain.entities.Room;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/room")
public interface RoomHandler {

    @PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> createARoom(@RequestBody Room room);

    @PutMapping(value = "/update/{roomId}", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> updateRoomWithNumber(@PathVariable("roomId") Integer salleId, int numero) throws Exception;

    @PostMapping
    ResponseEntity<Void> createTwoRoom(@RequestBody List<Room> rooms);

    @DeleteMapping
    ResponseEntity<Void> deleteAllRooms();

}
