package com.cegefos.tp1.controller.impl;

import com.cegefos.tp1.controller.SalleController;
import com.cegefos.tp1.entity.Salle;
import com.cegefos.tp1.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SalleControllerImpl implements SalleController {

    @Autowired
    private SalleService salleService;


    public void createASalle(@RequestBody Salle salle) {
        salleService.createSalle(salle);
    }


    public void updateSalleWithNumber(@PathVariable("salleId") Integer salleId, int numero) {
        try {
            salleService.updateSalle(salleId, numero);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void createListSalle(List<Salle> salles) {
        salleService.createTwoSalles(salles);
    }

    public void deleteAllSalles() {
        salleService.deleteAllSalles();
    }

}
