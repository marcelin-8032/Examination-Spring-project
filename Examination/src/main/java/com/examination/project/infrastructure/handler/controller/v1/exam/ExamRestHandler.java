package com.examination.project.infrastructure.handler.controller.v1.exam;


import com.examination.project.domain.entities.Exam;
import com.examination.project.domain.entities.Room;
import com.examination.project.domain.fixtures.ExamUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("v1/exam")
@Slf4j
@RequiredArgsConstructor
public class ExamRestHandler implements ExamHandler {

    private static final String TASKS_LIST_NOT_FOUND = "Not found";
    private final ExamUseCase examUseCase;

    // private final ExamMapper examMapper;

    @Override
    @PostMapping(value = "/create", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createExams(@RequestBody List<Exam> exams) {
        log.info("This list of exams {} have been created: ", exams);
        return examUseCase.createExams(exams).fold(
                a -> ResponseEntity.badRequest().build(),
                list -> ResponseEntity.status(HttpStatus.CREATED).build()
        );
    }

    @Override
    @GetMapping(value = "/exams")
    public ResponseEntity<Collection<Exam>> getAllExams() {
        return examUseCase.getAllExams().fold(
                b -> ResponseEntity.notFound().build(),
                exams -> new ResponseEntity<>(HttpStatus.FOUND)
        );
    }

    @Override
    @GetMapping(value = "/examsByDate")
    public ResponseEntity<Collection<Exam>> getExamsByDate(@RequestBody LocalDateTime date) {
        return examUseCase.getExamsByDate(date).fold(
                a -> ResponseEntity.notFound().build(),
                exams -> new ResponseEntity<>(HttpStatus.FOUND)
        );
    }

    @Override
    @GetMapping(value = "/examsByRoomDate")
    public ResponseEntity<Collection<Exam>> getExamsAtRoomAndAfterADate(@RequestBody Room room, LocalDateTime date) {
        return examUseCase.getExamsAtRoomAndAfterADate(room, date).fold(
                a -> ResponseEntity.notFound().build(),
                exams -> new ResponseEntity<>(HttpStatus.FOUND)
        );
    }

    @Override
    @GetMapping(value = "/examsByRoom")
    public ResponseEntity<Collection<Exam>> getExamsAtRecentDataAtSpecificRoom(@RequestBody Room room) {
        return examUseCase.getExamsAtRecentDateAtSpecificRoom(room).fold(
                a -> ResponseEntity.notFound().build(),
                exams -> new ResponseEntity<>(HttpStatus.FOUND)
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
    @GetMapping(value = "examPages/{roomId}")
    public ResponseEntity<Page<Exam>> getAllExamsByRoom(@PathVariable("roomId") Integer roomId, @NotNull final  Pageable pageable) {
        return examUseCase.getAllExamsByRoom(roomId, pageable).fold(
                a -> ResponseEntity.notFound().build(),
                ResponseEntity::ok
        );
    }

}
