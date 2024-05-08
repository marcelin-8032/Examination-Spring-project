package com.examination.project.utils.functional;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.util.stream.Collectors.toSet;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConditionalMapperTest {

    //given
    Set<String> stringSet;

    Consumer<Set<String>> setConsumer;


    @BeforeEach
    void setUp() {
        stringSet = new HashSet<>();
        stringSet.add("A");
        stringSet.add("B");
        stringSet.add("C");

        setConsumer = strings -> {
            strings.add("Aa");
            strings.add("Bb");
            strings.add("Cc");
        };
    }

    @Test
    void testNotNullOrEmpty() {

        //when
        ConditionalMapper.notNullOrEmpty(stringSet, setConsumer);

        //then
        assertEquals(Set.of("Aa", "Bb", "Cc", "A", "B", "C"), stringSet);
    }

    @Test
    void should_not_bind_NotNullOrEmpty_when_set_is_empty() {

        //given
        Set<String> stringSet = new HashSet<>();

        //when
        ConditionalMapper.notNullOrEmpty(stringSet, setConsumer);

        //then
        assertEquals(Set.of(), stringSet);
    }


    @Test
    void notNullOrEmptyWithFunctionIterate() {

        Set<String> stringSet1 = new HashSet<>();
        stringSet1.add("A");
        stringSet1.add("B");

        Function<String, String> convert = String::toLowerCase;

        Function<Set<String>, Set<String>> iterate = ts -> ts.stream().map(convert).collect(toSet());

        Consumer<Set<String>> bindTo = integers -> {
            integers.add("a");
            integers.add("b");
        };

         Optional.ofNullable(stringSet1)
                        .map(iterate).ifPresent(bindTo);
        System.out.println(stringSet1);

      //  ConditionalMapper.notNullOrEmpty(stringSet1, bindTo,convert);

      //  assertEquals("", stringSet1);

    }

    @Test
    void notNullOrEmptyWithDefault() {


    }

    @Test
    void notNullOrEmptyReplace() {
    }

    @Test
    void notNull() {
    }

    @Test
    void testNotNull() {
    }

    @Test
    void notNullWithDefault() {
    }

    @Test
    void testNotNullWithDefault() {
    }

    @Test
    void testNotNullWithDefault1() {
    }

    @Test
    void conditionalCheck() {
    }
}