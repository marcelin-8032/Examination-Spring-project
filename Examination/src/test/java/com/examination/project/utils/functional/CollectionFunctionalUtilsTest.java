package com.examination.project.utils.functional;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class CollectionFunctionalUtilsTest {

    @Test
    void should_map_return_null_for_empty_list() {

        //given
        Collection<String> stringList = Collections.emptyList();
        Function<String, String> function = s -> s + "1";

        //when
        val result = CollectionFunctionalUtils.map(stringList, function);

        //then
        assertNull(result);
        assertEquals(null, result);
    }

    @Test
    void should_map() {

        //given
        val stringList = List.of("a", "b", "c");
        Function<String, String> function = s -> s + "1";

        val expected = List.of("a1", "b1", "c1");

        //when
        val result = CollectionFunctionalUtils.map(stringList, function);

        //then
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void filter() {
    }

    @Test
    void findFirst() {
    }

    @Test
    void testFindFirst() {
    }

    @Test
    void findMax() {
    }

    @Test
    void allMatch() {
    }

    @Test
    void testAllMatch() {
    }

    @Test
    void testFindFirst1() {
    }


}