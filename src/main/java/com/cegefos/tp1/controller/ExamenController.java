package com.cegefos.tp1.controller;

import com.cegefos.tp1.entity.Examen;
import com.cegefos.tp1.entity.Salle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RequestMapping("/examen")
public interface ExamenController {

    @PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    void createExamens(@RequestBody List<Examen> examens);

    @GetMapping(value = "/examens")
    Collection<Examen> getAllExamens();

    @GetMapping(value = "/examensByDate")
    Collection<Examen> getExamensByDate(@RequestBody Date date);

    @GetMapping(value = "/examensBySalleDate")
    Collection<Examen> getExamAtSalleAndAfterADate(@RequestBody Salle salle, Date date);

    @GetMapping(value = "/examensBySalle")
    Collection<Examen> getExamensAtRecentDataAtSpecificSalle(@RequestBody Salle salle);

    @GetMapping
    Page<Examen> getAllExamensInPages(@NotNull final Pageable pageable);

    @GetMapping(value = "examens/{salleId}")
    Page<Examen> getAllExamensBySalle(@PathVariable("salleId") Integer salleId, @NotNull final Pageable pageable);


}
