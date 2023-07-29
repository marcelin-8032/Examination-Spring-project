package com.examination.project.handler.controller.room;

import com.examination.project.entities.Room;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/salle")
public interface RoomHandler {

    @PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    void createASalle(@RequestBody Room room);

    @PutMapping(value = "/update/{salleId}", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    void updateSalleWithNumber(@PathVariable("salleId") Integer salleId, int numero);

    @PostMapping
    void createListSalle(List<Room> rooms);

    @DeleteMapping
    void deleteAllSalles();

}
