package com.examination.project.domain.utils;

import java.util.UUID;
import java.util.function.Supplier;

public interface UUIDGenerator {

    Supplier<UUID> RANDOM_UUID = UUID::randomUUID;

    UUID generate() {
        return RANDOM_UUID.get();
    }

}
