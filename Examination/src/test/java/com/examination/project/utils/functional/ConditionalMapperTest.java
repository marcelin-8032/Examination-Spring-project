package com.examination.project.utils.functional;

import lombok.val;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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

        Set<String> s = new HashSet<>();
        s.add("A");
        s.add("B");

        Function<String, String> convert = String::toLowerCase;

        Consumer<Set<String>> bindTo = strings -> {
            strings.add("Ab");
            strings.add("Bb");
            System.out.println(strings);
        };

        ConditionalMapper.notNullOrEmpty(s, bindTo, convert);
        System.out.println(s);
        System.out.println(bindTo.andThen(a -> a
                .forEach(System.out::println)));
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