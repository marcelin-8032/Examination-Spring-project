package com.examination.project.handler.controller.room;

import com.examination.project.entities.Room;
import com.examination.project.usecases.room.RoomUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomRestHandler implements RoomHandler {

    @Autowired
    private RoomUseCase roomUseCase;


    public void createASalle(@RequestBody Room room) {
       // salleService.createSalle(roomEntity);
    }


    public void updateSalleWithNumber(@PathVariable("roomId") Integer salleId, int numero) {
        try {
            roomUseCase.updateRoom(salleId, numero);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void createListSalle(List<Room> rooms) {

        //salleService.createTwoSalles(salleEntities);
    }

    public void deleteAllSalles() {
        roomUseCase.deleteAllRooms();
    }

}
