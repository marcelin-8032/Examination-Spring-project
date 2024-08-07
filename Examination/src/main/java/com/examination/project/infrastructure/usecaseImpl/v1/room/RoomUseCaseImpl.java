package com.examination.project.infrastructure.usecaseImpl.v1.room;

import com.examination.project.domain.entities.Room;
import com.examination.project.domain.exception.ExaminationException;
import com.examination.project.domain.exception.ExaminationExceptionSanitize;
import com.examination.project.domain.usecases.v1.room.RoomUseCase;
import com.examination.project.infrastructure.mapper.struct.RoomMapper;
import com.examination.project.infrastructure.persistance.room.repository.RoomRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class RoomUseCaseImpl implements RoomUseCase {

    private final RoomRepository roomRepository;

    private final RoomMapper roomMapper;

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Either<ExaminationException, Room> createRoom(Room room) {
        return Try.of(() -> this.roomMapper.toRoomEntity(room))
                .map(this.roomRepository::save)
                .map(this.roomMapper::toRoom)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Void> createSeveralRooms(Collection<Room> rooms) {

        return Try.run(() -> this.roomMapper.toRoomEntities(rooms)
                        .forEach(this.roomRepository::save))
                .onSuccess(l -> log.info("{} rooms saved. {} ", rooms.size(), rooms))
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Void> updateRoom(Integer id, int number) {
        return Try.run(() -> this.roomRepository.findById(id)
                        .ifPresent(roomEntity -> {
                            roomEntity.setNumber(number);
                            roomRepository.save(roomEntity);
                        })).onFailure(cause -> log.error("there is a problem in updating room number"))
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    public Either<ExaminationException, Collection<Room>> getAllRooms() {
        return Try.of(this.roomRepository::findAll)
                .map(this.roomMapper::toRooms)
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }

    @Override
    @Transactional
    public Either<ExaminationException, Void> deleteAllRooms() {

        return Try.run(() -> this.jdbcTemplate.execute("delete from rooms"))
                .onFailure(cause -> log.error("The exams should be deleted first!"))
                .toEither()
                .mapLeft(ExaminationExceptionSanitize::sanitizeError);
    }
}
