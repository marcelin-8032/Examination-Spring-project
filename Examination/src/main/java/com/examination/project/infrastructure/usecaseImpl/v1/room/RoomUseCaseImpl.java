package com.examination.project.infrastructure.usecaseImpl.v1.room;

import com.examination.project.domain.entities.Room;
import com.examination.project.domain.exception.ExaminationException;
import com.examination.project.domain.exception.ExaminationExceptionSanitize;
import com.examination.project.domain.usecases.v1.room.RoomUseCase;
import com.examination.project.infrastructure.persistance.exam.repository.ExamRepository;
import com.examination.project.infrastructure.persistance.room.repository.RoomRepository;
import com.examination.project.infrastructure.mapper.ExamMapper;
import com.examination.project.infrastructure.mapper.RoomMapper;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class RoomUseCaseImpl implements RoomUseCase {

    private final RoomRepository roomRepository;

    private final ExamRepository examRepository;

    private final RoomMapper roomMapper;

    private final ExamMapper examMapper;

    @Override
    public Either<ExaminationException, Room> createRoom(Room room) {
        return Try.of(() -> this.roomMapper.toRoomEntity(room))
                .map(this.roomRepository::save)
                .map(this.roomMapper::toRoom)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Void> deleteAllRooms() {
        var examList =
                Try.of(() -> this.examRepository.findAll())
                        .map(this.examMapper::toExams);

        Try.run(() -> examList.map(xl -> xl.stream()
                        .map(exam -> exam.withRoom(null)))
                .map(examStream ->
                        examStream.map(this.examMapper::toExamEntity)
                                .map(this.examRepository::save)));

        return Try.run(() -> this.roomRepository.deleteAll())
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }


    @Override
    public Either<ExaminationException, Void> updateRoom(Integer id, int numero) throws Exception {
        return Try.run(() -> this.roomRepository.findById(id)
                        .ifPresent(roomEntity -> {
                            roomEntity.setRoomId(numero);
                            roomRepository.save(roomEntity);
                        })).onFailure(cause -> log.error("there is a problem in updating salle number"))
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Void> createTwoRooms(Collection<Room> rooms) {
        var listRoomEntities =
                Try.of(() -> this.roomMapper.toRoomEntities(rooms));

        return Try.run(() -> listRoomEntities.toJavaStream()
                        .map(roomEntities -> roomEntities.iterator().next())
                        .map(this.roomRepository::save)
                )
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }
}
