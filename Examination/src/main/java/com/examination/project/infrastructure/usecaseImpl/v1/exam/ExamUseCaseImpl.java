package com.examination.project.infrastructure.usecaseImpl.v1.exam;

import com.examination.project.domain.entities.Exam;
import com.examination.project.domain.entities.Room;
import com.examination.project.domain.exception.ExaminationException;
import com.examination.project.domain.exception.ExaminationExceptionSanitize;
import com.examination.project.domain.usecases.v1.exam.ExamUseCase;
import com.examination.project.infrastructure.mapper.struct.ExamMapper;
import com.examination.project.infrastructure.mapper.struct.RoomMapper;
import com.examination.project.infrastructure.persistance.exam.repository.ExamRepository;
import com.examination.project.infrastructure.persistance.room.repository.RoomRepository;
import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import static com.examination.project.utils.DateUtils.toInstant.convertTo;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExamUseCaseImpl implements ExamUseCase {

    private final ExamRepository examRepository;

    private final RoomRepository roomRepository;

    private final ExamMapper examMapper;

    private final RoomMapper roomMapper;

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Either<ExaminationException, Collection<Exam>> createExams(List<Exam> exams) {

        return Try.of(() -> this.examMapper.toExamEntities(exams))
                .map(examEntities ->
                        examEntities.stream().map(this.examRepository::save).toList())
                .map(this.examMapper::toExams)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Exam> createExam(Exam exam) {
        return Try.of(() -> this.examMapper.toExamEntity(exam))
                .map(this.examRepository::save)
                .map(this.examMapper::toExam)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Collection<Exam>> getAllExams() {
        return Try.of(this.examRepository::findAll)
                .map(this.examMapper::toExams)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Collection<Exam>> getExamsByDate(LocalDateTime localDateTime) {
        return Try.of(() -> convertTo(localDateTime))
                .map(this.examRepository::findByExamDate)
                .map(this.examMapper::toExams)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Collection<Exam>> getExamsAtRoomAndGivenDate(Option<Room> room, LocalDateTime localDateTime) {
        return Try.of(() -> this.roomMapper.optionToOptional(room))
                .map(room1 -> {
                    this.roomRepository.findById(room1.get().roomId());
                    return this.examRepository.findByRoomAndExamDate(room1.get(), localDateTime);
                }).onFailure(cause -> log.error("there is a problem in getting exams at Given Room and Date"))
                .map(this.examMapper::toExams)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Collection<Exam>> getExamsAtRoomAndAfterADate(Integer roomId, LocalDateTime localDateTime) {
        return Try.of(() -> this.roomRepository.findById(roomId))
                .map(roomEntity -> {
                    this.roomMapper.unwrapReferenceRoom(roomEntity);
                    return roomEntity.map(entity ->
                                    this.examRepository.findByRoomAndExamDateGreaterThan(entity, convertTo(localDateTime)))
                            .orElseThrow();
                }).onFailure(cause -> log.error("there is a problem in getting exams at Given Room and after Date: {}" + localDateTime))
                .map(this.examMapper::toExams)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Collection<Exam>> getExamsAtRecentDateAtSpecificRoom(Room room) {

        return Try.of(() -> this.roomMapper.toRoomEntity(room))
                .map(this.examRepository::findByRoomOrderByExamDateDesc)
                .map(this.examMapper::toExams)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Page<Exam>> getAllExamsInPages(Pageable pageable) {
        return Try.of(() -> PageRequest.of(0, 2, Sort.Direction.ASC, "exam_id"))
                .map(this.examRepository::findAll)
                .map(this.examMapper::pageExamEntityToPageExamDto)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Page<Exam>> getAllExamsByRoom(Integer roomId, Pageable pageable) {

        return Try.of(() -> PageRequest.of(0, 3, Sort.Direction.DESC, "room_id"))
                .map(pageable2 -> this.examRepository.findByRoom(roomId, pageable2))
                .map(this.examMapper::pageExamEntityToPageExamDto)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    @Transactional
    public Either<ExaminationException, Void> deleteAllExams() {

        return Try.run(() -> this.jdbcTemplate.execute("delete from students_exams"))
                .andThen(() -> this.jdbcTemplate.execute("delete from exams"))
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Collection<Exam>> fetchExamsAssignedToSpecificStudent(Integer studentId) {

        return Try.of(() -> this.examRepository.findExamsByStudentId(studentId))
                .map(this.examMapper::toExams)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }
}
