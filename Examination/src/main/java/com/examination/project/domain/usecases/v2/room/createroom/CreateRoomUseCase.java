package com.examination.project.domain.usecases.v2.room.createroom;

import com.examination.project.domain.exception.IntegrityConstraintException;
import com.examination.project.domain.entities.Room;
import com.examination.project.domain.exception.ExaminationException;
import com.examination.project.domain.usecases.v2.UseCaseAction;
import com.examination.project.domain.usecases.v2.room.RoomUseCase;
import com.examination.project.utils.misc.UUIDGenerator;
import com.examination.project.domain.valueobject.FunctionalUniqueId;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import io.vavr.control.Either;
import lombok.AllArgsConstructor;

import java.util.function.Function;
import java.util.function.Predicate;

import static com.examination.project.domain.usecases.v2.room.RoomUseCase.RoomUseCaseAction.CREATE_ROOM;

@AllArgsConstructor
public class CreateRoomUseCase implements RoomUseCase<CreateRoomPort, CreateRoomResult> {

    private final UUIDGenerator uuidGenerator;

    private final CreateRoomStore createRoomStore;

    @Override
    public Either<ExaminationException, CreateRoomResult> execute(CreateRoomPort port) {
//
//        final CheckedFunction0<Either<ExaminationException, CreateRoomResult>> retryableSupplier = Retry
//                .decorateCheckedSupplier(retryPolicy(), this::execute);

        return null;
    }

    @Override
    public UseCaseAction<RoomUseCaseAction> action() {
        return CREATE_ROOM;
    }


    private Either<ExaminationException, CreateRoomResult> execute() {

        return null;
//        return Function0.of(this::generate)
//                .andThen(this::register)
//                .apply();
    }

    private Room generate() {

        final Function<FunctionalUniqueId, Room> roomBuilder = id -> {
            final Room room = Room.builder()
                    .roomId(Integer.valueOf(id.getId()))
                    .build();

            return room;
        };

        return null;
//        return Function0.of(this.uuidGenerator::generate)
//               // .andThen(roomBuilder)
//                .apply();
    }


    private Retry retryPolicy() {

        final Predicate<Either<Exception, Room>> retryOn = e -> e.isLeft() && e.getLeft() instanceof IntegrityConstraintException;

        final RetryConfig retryConfig = RetryConfig.<Either<Exception, Room>>custom()
                .maxAttempts(3)
                .retryOnResult(retryOn)
                .failAfterMaxAttempts(false)
                .build();
        return RetryRegistry.of(retryConfig)
                .retry("CreateRoomUseCase");
    }

}
