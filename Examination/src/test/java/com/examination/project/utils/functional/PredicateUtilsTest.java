package com.examination.project.utils.functional;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class PredicateUtilsTest {

    @Test
    void fold() {

        Function<Boolean, String> function = aBoolean -> "true";

        Supplier<String> supplier1 = () -> "true";
        Supplier<String> supplier2 = () -> "false";

        val result = PredicateUtils.fold(supplier1, supplier2);
        assertEquals(function.toString(), result.toString());

    }
}