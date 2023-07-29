package com.examination.project.handler.controller.exam;


import com.examination.project.entities.Exam;
import com.examination.project.entities.Room;
import com.examination.project.mapper.ExamMapper;
import com.examination.project.usecases.exam.ExamUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ExamRestHandler implements ExamHandler {

    private final ExamUseCase examUseCase;

    private final ExamMapper examMapper;

    @Override
    public void createExams(List<Exam> exams) {

    }

    @Override
    public Collection<Exam> getAllExams() {
        return null;
    }

    @Override
    public Collection<Exam> getExamsByDate(LocalDateTime date) {
        return null;
    }

    @Override
    public Collection<Exam> getExamsAtRoomAndAfterADate(Room room, LocalDateTime date) {
        return null;
    }

    @Override
    public Collection<Exam> getExamensAtRecentDataAtSpecificSalle(Room room) {
        return null;
    }

    @Override
    public Page<Exam> getAllExamsInPages(Pageable pageable) {
        return null;
    }

    @Override
    public Page<Exam> getAllExamsByRoom(Integer salleId, Pageable pageable) {
        return null;
    }


//
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
//    public Collection<Exam> getExamsAtRoomAndAfterADate(@RequestBody Room room, Date date) {
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
