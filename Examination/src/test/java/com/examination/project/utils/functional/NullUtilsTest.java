package com.examination.project.utils.functional;

import io.vavr.Function2;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

class NullUtilsTest {

    @Test
    void testAcceptIfNotNull() {

        Consumer<Object> consumer = System.out::println;

        NullUtils.acceptIfNotNull(consumer, null);

    }

    @Test
    void acceptNotNull() {

        Consumer<Object> consumer = System.out::println;
        Function2<String, String, Object> function2 = (s, s2) -> null;

        NullUtils.acceptNotNull(consumer, "A", "B", function2);

    }

    @Test
    void ifConditionAndNotNull() {


    }

    @Test
    void ifNotNull() {


    }

    @Test
    void testIfNotNull() {


    }

    @Test
    void ifNotNullOr() {


    }

    @Test
    void testAcceptIfNotNull1() {


    }

    @Test
    void acceptIfNot() {


    }

    @Test
    void testAcceptIfNotNull2() {


    }

    @Test
    void testAcceptIfNotNull3() {


    }

    @Test
    void findFirst() {

    }

    @Test
    void eval() {

    }

    @Test
    void emptyStringIfNull() {
    }


    @Test
    void nullIfEmptyString() {

    }

    @Test
    void evalOrEmpty() {


    }
}