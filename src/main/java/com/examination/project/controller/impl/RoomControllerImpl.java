package com.examination.project.controller.impl;

import com.examination.project.controller.RoomController;
import com.examination.project.persistance.entities.RoomEntity;
import com.examination.project.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomControllerImpl implements RoomController {

    @Autowired
    private SalleService salleService;


    public void createASalle(@RequestBody RoomEntity roomEntity) {
        salleService.createSalle(roomEntity);
    }


    public void updateSalleWithNumber(@PathVariable("salleId") Integer salleId, int numero) {
        try {
            salleService.updateSalle(salleId, numero);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void createListSalle(List<RoomEntity> salleEntities) {
        salleService.createTwoSalles(salleEntities);
    }

    public void deleteAllSalles() {
        salleService.deleteAllSalles();
    }

}
