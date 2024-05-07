package com.examination.project.utils.functional;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class StringExtensionsTest {

    @Test
    void should_split_when_condition_is_true() {

        String str = "some;Strings;is;created;for;testing";

        val result = StringExtensions.toArray(str, true, ";");

        assertNotNull(result);
        assertEquals(6, result.length);
        assertEquals("Strings", result[1]);
    }

    @Test
    void should_not_split_when_condition_is_false() {

        String str = "some;Strings;is;created;for;testing";

        val result = StringExtensions.toArray(str, false, ";");

        assertNotNull(result);
        assertEquals(1, result.length);
        assertEquals(List.of("some;Strings;is;created;for;testing"), Arrays.stream(result).collect(Collectors.toList()));
    }
}