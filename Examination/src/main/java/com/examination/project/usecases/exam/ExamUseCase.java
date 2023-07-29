package com.examination.project.usecases.exam;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import com.examination.project.entities.Exam;
import com.examination.project.entities.Room;
import com.examination.project.exception.ExaminationException;
import io.vavr.control.Either;
import io.vavr.control.Option;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ExamUseCase {

    Either<ExaminationException, Collection<Exam>> createExams(List<Exam> exams);

    Either<ExaminationException, Collection<Exam>> getAllExams();

    Either<ExaminationException, Collection<Exam>> getExamsByDate(LocalDateTime localDateTime);

    Either<ExaminationException, Collection<Exam>> getExamAtRoomAndGivenDate(Integer id, Option<Room> salle, LocalDateTime localDateTime);

    Either<ExaminationException, Collection<Exam>> getExamAtRoomAndAfterADate(Room room, LocalDateTime localDateTime);

    Either<ExaminationException, Collection<Exam>> getExamsAtRecentDataAtSpecificRoom(Room room);

    Either<ExaminationException, Page<Exam>> getAllExamsInPages(Pageable pageable);

    Either<ExaminationException, Page<Exam>> getAllExamsByRoom(Integer id, Pageable pageable);

}
