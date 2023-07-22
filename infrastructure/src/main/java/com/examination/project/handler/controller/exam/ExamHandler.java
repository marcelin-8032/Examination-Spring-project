package com.examination.project.handler.controller.exam;

import com.examination.project.entities.Exam;
import com.examination.project.entities.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RequestMapping("/examen")
public interface ExamHandler {

    @PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    void createExamens(@RequestBody List<Exam> examenEntities);

    @GetMapping(value = "/examens")
    Collection<Exam> getAllExamens();

    @GetMapping(value = "/examensByDate")
    Collection<Exam> getExamensByDate(@RequestBody Date date);

    @GetMapping(value = "/examensBySalleDate")
    Collection<Exam> getExamAtSalleAndAfterADate(@RequestBody Room room, Date date);

    @GetMapping(value = "/examensBySalle")
    Collection<Exam> getExamensAtRecentDataAtSpecificSalle(@RequestBody Room room);

    @GetMapping
    Page<Exam> getAllExamensInPages(@NotNull final Pageable pageable);

    @GetMapping(value = "examens/{salleId}")
    Page<Exam> getAllExamensBySalle(@PathVariable("salleId") Integer salleId, @NotNull final Pageable pageable);


}
