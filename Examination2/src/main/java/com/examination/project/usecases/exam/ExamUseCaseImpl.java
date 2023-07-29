package com.examination.project.usecases.exam;

import com.examination.project.entities.Exam;
import com.examination.project.entities.Room;
import com.examination.project.exception.ExaminationException;
import com.examination.project.exception.ExaminationExceptionSanitize;
import com.examination.project.handler.persistance.exam.entities.ExamEntity;
import com.examination.project.handler.persistance.exam.repository.ExamRepository;
import com.examination.project.handler.persistance.room.repository.RoomRepository;
import com.examination.project.mapper.ExamMapper;
import com.examination.project.mapper.RoomMapper;
import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import static org.springframework.data.domain.PageRequest.of;

@Service
@Slf4j
public class ExamUseCaseImpl implements ExamUseCase {
    @Autowired
    private  ExamRepository examRepository;
    @Autowired
    private  RoomRepository roomRepository;
    @Autowired
    private ExamMapper examMapper;
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public Either<ExaminationException, Collection<Exam>> createExams(List<Exam> exams) {
        val examsEntities = this.examMapper.toExamEntities(exams);
        for (var examEntity : examsEntities) {
            if (examsEntities.iterator().hasNext()) {
                examsEntities.add(examEntity);
                this.examRepository.save(examEntity);
            }
        }

        return Try.of(() -> this.examMapper.toExams(examsEntities))
                .toEither().mapLeft(ExaminationExceptionSanitize::sanitizeError);
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
        val a = this.examRepository.findExamenByDateExam(localDateTime);
        this.examMapper.toExams(a);
        return Try.of(() -> this.examRepository.findExamenByDateExam(localDateTime))
                .map(this.examMapper::toExams)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Collection<Exam>> getExamsAtRoomAndGivenDate(Option<Room> room, LocalDateTime localDateTime) {
        Collection<ExamEntity> examEntities = null;
        if (room.isDefined()) {
            var entity = this.roomRepository.findById(room.get().roomId());
            if (entity.isPresent()) {
                examEntities = this.examRepository.findExamsByRoomAndDate(room.get(), localDateTime);
            }
        }
        Collection<ExamEntity> finalExamEntities = examEntities;
        return Try.of(() -> this.examMapper.toExams(finalExamEntities))
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Collection<Exam>> getExamsAtRoomAndAfterADate(Room room, LocalDateTime localDateTime) {
        var entity = this.roomRepository.findById(room.roomId());
        Collection<ExamEntity> examEntities = null;

        if (entity.isPresent()) {
            val roomEntity = this.roomMapper.toRoomEntity(room);
            examEntities = this.examRepository.findByRoomAndDateExamGreaterThan(roomEntity, localDateTime);
        }

        Collection<ExamEntity> finalExamEntities = examEntities;

        return Try.of(() -> this.examMapper.toExams(finalExamEntities))
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Collection<Exam>> getExamsAtRecentDataAtSpecificRoom(Room room) {
        return Try.of(() -> this.roomMapper.toRoomEntity(room))
                .map(this.examRepository::findTopByRoomOrderByDateExamDesc)
                .map(this.examMapper::toExams)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Page<Exam>> getAllExamsInPages(Pageable pageable) {
        return Try.of(() -> of(0, 2, Sort.Direction.ASC, "exam_id"))
                .map(this.examRepository::findAllExams)
                .map(this.examMapper::pageExamEntityToPageExamDto)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Page<Exam>> getAllExamsByRoom(Integer roomId, Pageable pageable) {
        pageable = PageRequest.of(0, 3, Sort.Direction.DESC, "room_id");
        val finalPageable = pageable;
        return Try.of(() -> this.examRepository.findByRoom(roomId, finalPageable))
                .map(this.examMapper::pageExamEntityToPageExamDto)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);

    }

}