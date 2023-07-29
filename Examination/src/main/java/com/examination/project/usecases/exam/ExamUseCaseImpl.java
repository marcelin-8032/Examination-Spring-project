package com.examination.project.usecases.exam;

import com.examination.project.entities.Exam;
import com.examination.project.entities.Room;
import com.examination.project.exception.ExaminationException;
import com.examination.project.exception.ExaminationExceptionSanitize;
import com.examination.project.handler.persistance.exam.repository.ExamRepository;
import com.examination.project.handler.persistance.room.repository.RoomRepository;
import com.examination.project.mapper.ExamMapper;
import com.examination.project.mapper.RoomMapper;
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
    public Either<ExaminationException, Collection<Exam>> getExamAtRoomAndGivenDate(Integer id, Option<Room> room, LocalDateTime localDateTime) {
        //        Integer id = 0;
//        var roomEntity = roomRepository.findById(id).get();
//        return examMapper.toExams(examRepository.findByRoomAndDateExamGreaterThan(roomEntity, date));

        return Try.of(() -> this.roomRepository.findById(id))
                .filter(Optional::isPresent)
                .map(this.examRepository::findByRoomAndDateExamGreaterThan)
                .map(this.examMapper::toExams)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Collection<Exam>> getExamAtRoomAndAfterADate(Room room, LocalDateTime localDateTime) {
//        Integer id = 0;
//        var roomEntity = roomRepository.findById(id).get();
//        return examMapper.toExams(examRepository.findByRoomAndDateExamGreaterThan(roomEntity, date));

        return null;
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
        return Try.of(() -> PageRequest.of(0, 2, Sort.Direction.ASC, "exam_id"))
                .map(this.examRepository::findAllExams)
                .map(this.examMapper::pageExamEntityToPageExamDto)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Page<Exam>> getAllExamsByRoom(Integer id, Pageable pageable) {
        //        pageable = PageRequest.of(0, 3, Sort.Direction.DESC, "date_exam");
//       // return examMapper.toExamPage(examRepository.findByInvigilator(id, pageable));

        return Try.of(() -> PageRequest.of(0, 3, Sort.Direction.DESC, "date_exam"))
                .map(this.examRepository.findByInvigilator(id,pageable))
                .map(this.examMapper::pageExamEntityToPageExamDto)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }


//
//    @Override
//    public Collection<Exam> getExamsByDate(Date date) {
//        return examMapper.toExams(examRepository.findExamenByDateExam(date));
//    }
//
//    @Override
//    public Collection<Exam> getExamAtRoomAndAfterADate(Room room, Date date) {
//        Integer id = 0;
//        var roomEntity = roomRepository.findById(id).get();
//        return examMapper.toExams(examRepository.findByRoomAndDateExamGreaterThan(roomEntity, date));
//    }
//
//    @Override
//    public Collection<Exam> getExamsAtRecentDataAtSpecificRoom(Room room) {
//        return examMapper.toExams(
//                examRepository.findTopByRoomOrderByDateExamDesc(
//                        roomMapper.toRoomEntity(room)));
//    }
//
//    @Override
//    public Page<Exam> getAllExamsInPages(Pageable pageable) {
//        pageable = PageRequest.of(0, 2, Sort.Direction.ASC, "examen_id");
//      //  return examMapper.toExamPage(examRepository.findAllExams(pageable));
//        return  null;
//    }
//
//    @Override
//    public Page<Exam> getAllExamsByRoom(Integer id, Pageable pageable) {
//        pageable = PageRequest.of(0, 3, Sort.Direction.DESC, "date_exam");
//       // return examMapper.toExamPage(examRepository.findByInvigilator(id, pageable));
//        return null;
//    }


}
