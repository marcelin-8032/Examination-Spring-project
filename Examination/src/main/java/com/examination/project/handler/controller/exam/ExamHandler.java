package com.examination.project.handler.controller.exam;

import com.examination.project.entities.Exam;
import com.examination.project.entities.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@RequestMapping("/exams")
public interface ExamHandler {

    @PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    void createExams(@RequestBody List<Exam> exams);

    @GetMapping(value = "/exams")
    Collection<Exam> getAllExams();

    @GetMapping(value = "/examsByDate")
    Collection<Exam> getExamsByDate(@RequestBody LocalDateTime date);

    @GetMapping(value = "/examsBySalleDate")
    Collection<Exam> getExamsAtRoomAndAfterADate(@RequestBody Room room, LocalDateTime date);

    @GetMapping(value = "/examsByRoom")
    Collection<Exam> getExamensAtRecentDataAtSpecificSalle(@RequestBody Room room);

    @GetMapping
    Page<Exam> getAllExamsInPages(@NotNull final Pageable pageable);

    @GetMapping(value = "exams/{roomId}")
    Page<Exam> getAllExamsByRoom(@PathVariable("roomId") Integer roomId, @NotNull final Pageable pageable);

}
