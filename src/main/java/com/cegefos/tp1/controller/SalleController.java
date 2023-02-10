package com.cegefos.tp1.controller;

import com.cegefos.tp1.entity.Salle;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/salle")
public interface SalleController {

    @PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    void createASalle(@RequestBody Salle salle);

    @PutMapping(value = "/update/{salleId}", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    void updateSalleWithNumber(@PathVariable("salleId") Integer salleId, int numero);
    @PostMapping
    void createListSalle(List<Salle> salles);

    @DeleteMapping
     void deleteAllSalles();


}
