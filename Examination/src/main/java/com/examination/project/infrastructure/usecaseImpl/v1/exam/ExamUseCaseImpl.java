package com.examination.project.infrastructure.usecaseImpl.v1.exam;

import com.examination.project.domain.entities.Exam;
import com.examination.project.domain.entities.Room;
import com.examination.project.domain.exception.ExaminationException;
import com.examination.project.domain.exception.ExaminationExceptionSanitize;
import com.examination.project.infrastructure.mapper.ExamMapper;
import com.examination.project.infrastructure.mapper.RoomMapper;
import com.examination.project.domain.usecases.v1.exam.ExamUseCase;
import com.examination.project.infrastructure.persistance.exam.entities.ExamEntity;
import com.examination.project.infrastructure.persistance.exam.repository.ExamRepository;
import com.examination.project.infrastructure.persistance.room.repository.RoomRepository;
import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.data.domain.PageRequest.of;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExamUseCaseImpl implements ExamUseCase {

    private final ExamRepository examRepository;

    private final RoomRepository roomRepository;

    private final ExamMapper examMapper;

    private final RoomMapper roomMapper;

    @Override
    public Either<ExaminationException, Collection<Exam>> createExams(List<Exam> exams) {
        //        val examsEntities = this.examMapper.toExamEntities(exams);
//        for (var examEntity : examsEntities) {
//            if (examsEntities.iterator().hasNext()) {
//                examsEntities.add(examEntity);
//                this.examRepository.save(examEntity);
//            }
//        }
//        return Try.of(() -> this.examMapper.toExams(examsEntities))
//                .toEither().mapLeft(ExaminationExceptionSanitize::sanitizeError);
        return Try.of(() -> this.examMapper.toExamEntities(exams))
                .map(examEntities ->
                        examEntities.stream().map(this.examRepository::save)
                                .collect(Collectors.toList()))
                .map(this.examMapper::toExams)
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
        val examEntities = this.examRepository.findByExamDate(localDateTime);
        this.examMapper.toExams(examEntities);
        return Try.of(() -> this.examRepository.findByExamDate(localDateTime))
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
    public Either<ExaminationException, Collection<Exam>> getExamsAtRoomAndAfterADate(Room room, LocalDateTime localDateTime) {
        return Try.of(() -> this.roomRepository.findById(room.roomId()))
                .map(roomEntity -> {
                    this.roomMapper.unwrapReferenceRoom(roomEntity);
                    return roomEntity.map(entity ->
                                    this.examRepository.findByRoomAndExamDateGreaterThan(entity, localDateTime))
                            .orElse(null);
                }).onFailure(cause -> log.error("there is a problem in getting exams at Given Room and after a Date"))
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
        return Try.of(() -> of(0, 2, Sort.Direction.ASC, "exam_id"))
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
    public Either<ExaminationException, Exam> createExam(Exam exam) {
        return Try.of(() -> this.examMapper.toExamEntity(exam))
                .map(this.examRepository::save)
                .map(this.examMapper::toExam)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }
}
