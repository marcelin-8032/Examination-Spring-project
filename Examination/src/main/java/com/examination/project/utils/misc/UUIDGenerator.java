package com.examination.project.utils.misc;

import java.util.UUID;
import java.util.function.Supplier;

public interface UUIDGenerator {

    Supplier<UUID> RANDOM_UUID = UUID::randomUUID;

    default UUID generate() {
        return RANDOM_UUID.get();
    }

}
