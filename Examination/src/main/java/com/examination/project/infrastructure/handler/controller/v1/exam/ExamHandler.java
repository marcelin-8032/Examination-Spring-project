package com.examination.project.infrastructure.handler.controller.v1.exam;

import com.examination.project.domain.entities.Exam;
import com.examination.project.domain.entities.Room;
import com.examination.project.domain.entities.Student;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Tag(name = " Exams API", description = "Exam management")
public interface ExamHandler {

    ResponseEntity<Void> createExams(List<Exam> exams);

    ResponseEntity<Collection<Exam>> getAllExams();

    ResponseEntity<Collection<Exam>> getExamsByDate(LocalDateTime date);

    ResponseEntity<Collection<Exam>> getExamsAtRoomAndAfterADate(Room room, LocalDateTime date);

    ResponseEntity<Collection<Exam>> getExamsAtRecentDataAtSpecificRoom(Room room);

    ResponseEntity<Page<Exam>> getAllExamsInPages(Pageable pageable);

    ResponseEntity<Page<Exam>> getAllExamsByRoom(Integer roomId, Pageable pageable);

    ResponseEntity<Void> addExam(Exam exam);
}
