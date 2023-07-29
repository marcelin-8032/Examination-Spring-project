package com.examination.project.handler.controller.exam;


import com.examination.project.entities.Exam;
import com.examination.project.entities.Room;
import com.examination.project.mapper.ExamMapper;
import com.examination.project.usecases.exam.ExamUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public ResponseEntity<Void> createExams(List<Exam> exams) {
        return examUseCase.createExams(exams).fold(
                a -> ResponseEntity.notFound(TASKS_LIST_NOT_FOUND).build(),
                list -> ResponseEntity.ok(list)
        );
    }

    @Override
    public ResponseEntity<Collection<Exam>> getAllExams() {
        return (ResponseEntity<Collection<Exam>>) examUseCase.getAllExams().fold(
                b->ResponseEntity.notFound(),
                a->ResponseEntity.ok()

        );
    }

    @Override
    public ResponseEntity<Collection<Exam>> getExamsByDate(LocalDateTime date) {
        return null;
    }

    @Override
    public ResponseEntity<Collection<Exam>> getExamsAtRoomAndAfterADate(Room room, LocalDateTime date) {
        return null;
    }

    @Override
    public ResponseEntity<Collection<Exam>> getExamensAtRecentDataAtSpecificSalle(Room room) {
        return null;
    }

    @Override
    public ResponseEntity<Page<Exam>> getAllExamsInPages(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<Page<Exam>> getAllExamsByRoom(Integer roomId, Pageable pageable) {
        return null;
    }


//    @Override
//    public void createExams(@RequestBody List<Exam> exams) {
//        examUseCase.createExams(exams);
//    }
//
//    @Override
//    public Collection<Exam> getAllExams() {
//        return examUseCase.getAllExams();
//    }
//
//    @Override
//    public ResponseEntity<Collection<Exam>> getExamensByDate(@RequestBody LocalDateTime date) {
//        return examUseCase.getExamsByDate(date);
//    }
//
//    @Override
//    public Collection<Exam> getExamsAtRoomAndAfterADate(@RequestBody Room room, LocalDateTime date) {
//        return examUseCase.getExamsAtRoomAndAfterADate(room, date);
//    }
//
//    @Override
//    public Collection<Exam> getExamensAtRecentDataAtSpecificSalle(@RequestBody Room rooms) {
//        return examUseCase.getExamsAtRecentDataAtSpecificRoom(rooms);
//    }
//
//    @Override
//    public Page<Exam> getAllExamsInPages(@NotNull final Pageable pageable) {
//        return examUseCase.getAllExamsInPages(pageable);
//    }
//
//    @Override
//    public Page<Exam> getAllExamsByRoom(@PathVariable("roomId") Integer salleId, @NotNull final Pageable pageable) {
//        return examUseCase.getAllExamsByRoom(salleId, pageable);
//    }

}
