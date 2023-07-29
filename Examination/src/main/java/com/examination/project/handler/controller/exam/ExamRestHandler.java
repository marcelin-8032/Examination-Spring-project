package com.examination.project.handler.controller.exam;

import com.examination.project.entities.Exam;
import com.examination.project.entities.Room;
import com.examination.project.mapper.ExamMapper;
import com.examination.project.usecases.exam.ExamUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
public class ExamRestHandler implements ExamHandler {

    @Autowired
    private ExamUseCase examUseCase;

    @Autowired
    private ExamMapper examMapper;

    @Override
    public void createExamens(@RequestBody List<Exam> exams) {
        examUseCase.createExams(exams);
    }

    @Override
    public Collection<Exam> getAllExamens() {
        return examUseCase.getAllExams();
    }

    @Override
    public ResponseEntity<Collection<Exam>> getExamensByDate(@RequestBody LocalDateTime date) {
        return examUseCase.getExamsByDate(date);
    }

    @Override
    public Collection<Exam> getExamAtSalleAndAfterADate(@RequestBody Room room, Date date) {
        return examUseCase.getExamAtRoomAndAfterADate(room, date);
    }

    @Override
    public Collection<Exam> getExamensAtRecentDataAtSpecificSalle(@RequestBody Room rooms) {
        return examUseCase.getExamsAtRecentDataAtSpecificRoom(rooms);
    }

    @Override
    public Page<Exam> getAllExamensInPages(@NotNull final Pageable pageable) {
        return examUseCase.getAllExamsInPages(pageable);
    }

    @Override
    public Page<Exam> getAllExamensBySalle(@PathVariable("salleId") Integer salleId, @NotNull final Pageable pageable) {
        return examUseCase.getAllExamsByRoom(salleId, pageable);
    }

}
