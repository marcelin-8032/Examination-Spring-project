package com.examination.project.infrastructure.handler.controller.v1.exam;


import com.examination.project.domain.entities.Exam;
import com.examination.project.domain.entities.Room;
import com.examination.project.domain.usecases.v1.exam.ExamUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/v1/" + "exams")
@Slf4j
@RequiredArgsConstructor
public class ExamRestHandler implements ExamHandler {

    private final ExamUseCase examUseCase;

    @Override
    @PostMapping(value = "/add")
    public ResponseEntity<Void> addExam(@RequestBody Exam exam) {
        return examUseCase.createExam(exam).fold(
                a -> ResponseEntity.badRequest().build(),
                exam1 -> ResponseEntity.status(HttpStatus.CREATED).build()
        );
    }

    @Override
    @PostMapping(value = "/addExams")
    public ResponseEntity<Void> createExams(@RequestBody List<Exam> exams) {
        log.info("This list of exams {} have been created: ", exams);
        return examUseCase.createExams(exams).fold(
                a -> ResponseEntity.badRequest().build(),
                list -> ResponseEntity.status(HttpStatus.CREATED).build()
        );
    }

    @Override
    @GetMapping
    public ResponseEntity<Collection<Exam>> getAllExams() {
        return examUseCase.getAllExams().fold(
                b -> ResponseEntity.notFound().build(),
                ResponseEntity::ok
        );
    }

    @Override
    @GetMapping(value = "examPages/{roomId}")
    public ResponseEntity<Page<Exam>> getAllExamsByRoom(@PathVariable("roomId") Integer roomId, @NotNull final Pageable pageable) {
        return examUseCase.getAllExamsByRoom(roomId, pageable).fold(
                a -> ResponseEntity.notFound().build(),
                ResponseEntity::ok
        );
    }

    @Override
    @GetMapping(value = "/date/{date}")
    public ResponseEntity<Collection<Exam>> getExamsByDate(@PathVariable
                                                         //  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
                                                           LocalDateTime date) {
        return examUseCase.getExamsByDate(date).fold(
                a -> ResponseEntity.notFound().build(),
                ResponseEntity::ok
        );
    }

    @Override
    @GetMapping(value = "/room")
    public ResponseEntity<Collection<Exam>> getExamsAtRoomAndAfterADate(@RequestBody Room room, LocalDateTime date) {
        return examUseCase.getExamsAtRoomAndAfterADate(room, date).fold(
                a -> ResponseEntity.notFound().build(),
                ResponseEntity::ok
        );
    }

    @Override
    @GetMapping(value = "/examsByRoom")
    public ResponseEntity<Collection<Exam>> getExamsAtRecentDataAtSpecificRoom(@RequestBody Room room) {
        return examUseCase.getExamsAtRecentDateAtSpecificRoom(room).fold(
                a -> ResponseEntity.notFound().build(),
                ResponseEntity::ok
        );
    }

    @Override
    @GetMapping("/examPages")
    public ResponseEntity<Page<Exam>> getAllExamsInPages(@NotNull final Pageable pageable) {
        return examUseCase.getAllExamsInPages(pageable).fold(
                a -> ResponseEntity.notFound().build(),
                ResponseEntity::ok
        );
    }

    @Override
    @DeleteMapping("/delete-all")
    public ResponseEntity<Void> deleteAllExams() {
        return examUseCase.deleteAllExams().fold(
                a -> ResponseEntity.notFound().build(),
                a -> ResponseEntity.status(HttpStatus.NO_CONTENT).build()
        );
    }
}
