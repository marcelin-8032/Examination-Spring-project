package com.examination.project.handler.controller.exam;


import com.examination.project.entities.Exam;
import com.examination.project.entities.Room;
import com.examination.project.mapper.ExamMapper;
import com.examination.project.usecases.exam.ExamUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@RestController
@Slf4j
public class ExamRestHandler implements ExamHandler {

    private static final String TASKS_LIST_NOT_FOUND = "Not found";
    private ExamUseCase examUseCase;
    private ExamMapper examMapper;

    @Autowired(required = true)
    public ExamRestHandler(ExamUseCase examUseCase, ExamMapper examMapper) {
        this.examUseCase = examUseCase;
        this.examMapper = examMapper;
    }

    @Override
    public ResponseEntity<Void> createExams(List<Exam> exams) {
        log.info("This list of exams {} have been created: ", exams);
        return examUseCase.createExams(exams).fold(
                a -> ResponseEntity.badRequest().build(),
                list -> ResponseEntity.status(HttpStatus.CREATED).build()
        );
    }

    @Override
    public ResponseEntity<Collection<Exam>> getAllExams() {
        return examUseCase.getAllExams().fold(
                b -> ResponseEntity.notFound().build(),
                exams -> new ResponseEntity<>(HttpStatus.FOUND)
        );
    }

    @Override
    public ResponseEntity<Collection<Exam>> getExamsByDate(LocalDateTime date) {
        return examUseCase.getExamsByDate(date).fold(
                a -> ResponseEntity.notFound().build(),
                exams -> new ResponseEntity<>(HttpStatus.FOUND)
        );
    }

    @Override
    public ResponseEntity<Collection<Exam>> getExamsAtRoomAndAfterADate(Room room, LocalDateTime date) {
        return examUseCase.getExamsAtRoomAndAfterADate(room, date).fold(
                a -> ResponseEntity.notFound().build(),
                exams -> new ResponseEntity<>(HttpStatus.FOUND)
        );
    }

    @Override
    public ResponseEntity<Collection<Exam>> getExamsAtRecentDataAtSpecificRoom(Room room) {
        return examUseCase.getExamsAtRecentDataAtSpecificRoom(room).fold(
                a -> ResponseEntity.notFound().build(),
                exams -> new ResponseEntity<>(HttpStatus.FOUND)
        );
    }

    @Override
    public ResponseEntity<Page<Exam>> getAllExamsInPages(Pageable pageable) {
        return examUseCase.getAllExamsInPages(pageable).fold(
                a -> ResponseEntity.notFound().build(),
                exams -> new ResponseEntity<>(HttpStatus.FOUND)
        );
    }

    @Override
    public ResponseEntity<Page<Exam>> getAllExamsByRoom(Integer roomId, Pageable pageable) {
        return examUseCase.getAllExamsByRoom(roomId, pageable).fold(
                a -> ResponseEntity.notFound().build(),
                exams -> new ResponseEntity<>(HttpStatus.FOUND)
        );
    }

}
