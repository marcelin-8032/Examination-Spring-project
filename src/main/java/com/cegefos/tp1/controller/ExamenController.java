package com.cegefos.tp1.controller;

import com.cegefos.tp1.persistance.entities.ExamEntity;
import com.cegefos.tp1.persistance.entities.RoomEntity;
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
    void createExamens(@RequestBody List<ExamEntity> examenEntities);

    @GetMapping(value = "/examens")
    Collection<ExamEntity> getAllExamens();

    @GetMapping(value = "/examensByDate")
    Collection<ExamEntity> getExamensByDate(@RequestBody Date date);

    @GetMapping(value = "/examensBySalleDate")
    Collection<ExamEntity> getExamAtSalleAndAfterADate(@RequestBody RoomEntity roomEntity, Date date);

    @GetMapping(value = "/examensBySalle")
    Collection<ExamEntity> getExamensAtRecentDataAtSpecificSalle(@RequestBody RoomEntity roomEntity);

    @GetMapping
    Page<ExamEntity> getAllExamensInPages(@NotNull final Pageable pageable);

    @GetMapping(value = "examens/{salleId}")
    Page<ExamEntity> getAllExamensBySalle(@PathVariable("salleId") Integer salleId, @NotNull final Pageable pageable);


}
