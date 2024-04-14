package com.examination.project.utils.misc;

import com.examination.project.domain.valueobject.FunctionalUniqueId;
import io.vavr.API;
import io.vavr.Function1;
import io.vavr.control.Either;
import io.vavr.control.Try;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.Patterns.$Left;
import static io.vavr.Patterns.$Right;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public interface IdGenerateToProvider {

    Supplier<UUID> RANDOM_UUID = UUID::randomUUID;

    UnaryOperator<String> format();

    FunctionalUniqueId build(String id);

    default FunctionalUniqueId generate() {
        return Function1.of(this::fromUUID)
                .apply(RANDOM_UUID.get());
    }

    default String generateId() {
        return generate().getId();
    }


    default FunctionalUniqueId migrate(String oldId) {

        Objects.requireNonNull(oldId);

        final Either<Throwable, FunctionalUniqueId> idEither =
                Try.of(() -> Function1.of(UUID::fromString)
                        .andThen(this::truncateUUID)
                        .apply(oldId)).toEither();
        return API.Match(idEither).of(
                Case($Right($()), v -> v),
                Case($Left($()), v -> fromString(oldId))

        );
    }

    private FunctionalUniqueId truncateUUID(UUID uuid) {

        Objects.requireNonNull(uuid);

        return Function1.of(UUID::toString)
                .andThen(this::normalize)
                .andThen(this::build)
                .apply(uuid);
    }

    private FunctionalUniqueId fromUUID(UUID uuid) {

        Objects.requireNonNull(uuid);

        return Function1.of(this::encodeUUID)
                .andThen(this::normalize)
                .andThen(this::build)
                .apply(uuid);

    }

    private String normalize(String id) {

        return Function1.of((String s) -> s.replaceAll("[^¨a-zA-Z0-9]", EMPTY))
                .andThen(String::toUpperCase)
                .andThen(s -> s.substring(0, 9))
                .andThen(format())
                .apply(id);
    }

    private FunctionalUniqueId fromString(String id) {
        Objects.requireNonNull(id);

        return Function1.of(this::normalize)
                .andThen(this::build)
                .apply(id);
    }

    private String encodeUUID(UUID uuid) {

        final ByteBuffer byteBuffer = ByteBuffer.allocate(16);

        byteBuffer.putLong(uuid.getMostSignificantBits());
        byteBuffer.putLong(uuid.getLeastSignificantBits());

        return Base64.getUrlEncoder()
                .withoutPadding()
                .encodeToString(byteBuffer.array());
    }

}
