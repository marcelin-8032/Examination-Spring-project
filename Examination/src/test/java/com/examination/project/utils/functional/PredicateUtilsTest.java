package com.examination.project.utils.functional;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class PredicateUtilsTest {

    @Test
    void should_fold() {

         //given
        Function<Boolean, String> expected1 = aBoolean -> Boolean.toString(true);
        Function<Boolean, String> expected2 = aBoolean -> Boolean.toString(false);

        Supplier<String> supplier1 = () -> "false";
        Supplier<String> supplier2 = () -> "true";

        //when
        val result = PredicateUtils.fold(supplier1, supplier2);

        //then
        assertEquals(expected1.apply(true), result.apply(true));
        assertEquals(expected2.apply(false), result.apply(false));
    }
}