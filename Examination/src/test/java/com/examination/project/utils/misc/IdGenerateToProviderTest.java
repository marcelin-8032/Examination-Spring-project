package com.examination.project.utils.misc;

import com.examination.project.domain.valueobject.FunctionalUniqueId;
import lombok.val;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IdGenerateToProviderTest {

    private static IdGenerateToProviderImpl idGenerateToProvider;

    @BeforeAll
    static void setUp() {
        idGenerateToProvider = new IdGenerateToProviderImpl();
    }


    @Test
    @Disabled
    void generatedId() {
        Supplier<UUID> uuidSupplier = () -> UUID.fromString("6b6b3453-8ea8-48e6-999b-e2543c8c7cd9");

       // when(idGenerateToProvider.generate()).thenReturn();

        val result = idGenerateToProvider.generate();
        assertEquals("", result);
    }

    static class IdGenerateToProviderImpl implements IdGenerateToProvider {

        @Override
        public UnaryOperator<String> format() {
            return s -> s;
        }

        @Override
        public FunctionalUniqueId build(String id) {
            return null;
        }

        @Override
        public FunctionalUniqueId generate() {
            return IdGenerateToProvider.super.generate();
        }

        @Override
        public String generateId() {
            return IdGenerateToProvider.super.generateId();
        }

        @Override
        public FunctionalUniqueId migrate(String oldId) {
            return IdGenerateToProvider.super.migrate(oldId);
        }
    }
}