package com.examination.project.handler.controller.exam;

import com.examination.project.entities.Exam;
import com.examination.project.entities.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@RequestMapping("/exams")
public interface ExamHandler {

    @PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> createExams(@RequestBody List<Exam> exams);

    @GetMapping(value = "/exams")
    ResponseEntity<Collection<Exam>> getAllExams();

    @GetMapping(value = "/examsByDate")
    ResponseEntity<Collection<Exam>> getExamsByDate(@RequestBody LocalDateTime date);

    @GetMapping(value = "/examsBySalleDate")
    ResponseEntity<Collection<Exam>> getExamsAtRoomAndAfterADate(@RequestBody Room room, LocalDateTime date);

    @GetMapping(value = "/examsByRoom")
    ResponseEntity<Collection<Exam>> getExamsAtRecentDataAtSpecificRoom(@RequestBody Room room);

    @GetMapping
    ResponseEntity<Page<Exam>> getAllExamsInPages(@NotNull final Pageable pageable);

    @GetMapping(value = "exams/{roomId}")
    ResponseEntity<Page<Exam>> getAllExamsByRoom(@PathVariable("roomId") Integer roomId, @NotNull final Pageable pageable);

}
