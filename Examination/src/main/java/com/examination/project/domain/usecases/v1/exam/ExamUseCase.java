package com.examination.project.domain.usecases.v1.exam;

import com.examination.project.domain.entities.Exam;
import com.examination.project.domain.entities.Room;
import com.examination.project.domain.exception.ExaminationException;
import io.vavr.control.Either;
import io.vavr.control.Option;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Service
public interface ExamUseCase {

    Either<ExaminationException, Collection<Exam>> createExams(List<Exam> exams);

    Either<ExaminationException, Collection<Exam>> getAllExams();

    Either<ExaminationException, Collection<Exam>> getExamsByDate(LocalDateTime localDateTime);

    Either<ExaminationException, Collection<Exam>> getExamsAtRoomAndGivenDate(Option<Room> room, LocalDateTime localDateTime);

    Either<ExaminationException, Collection<Exam>> getExamsAtRoomAndAfterADate(Room room, LocalDateTime localDateTime);

    Either<ExaminationException, Collection<Exam>> getExamsAtRecentDateAtSpecificRoom(Room room);

    Either<ExaminationException, Page<Exam>> getAllExamsInPages(Pageable pageable);

    Either<ExaminationException, Page<Exam>> getAllExamsByRoom(Integer roomId, Pageable pageable);

    Either<ExaminationException, Exam> createExam(Exam exam);

    Either<ExaminationException, Void> deleteAllExams();

    Either<ExaminationException, Collection<Exam>> fetchExamsAssignedToSpecificStudent(Integer studentId);
}
