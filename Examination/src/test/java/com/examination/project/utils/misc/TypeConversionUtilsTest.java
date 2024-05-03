package com.examination.project.utils.misc;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TypeConversionUtilsTest {

    @Test
    void mapSeparateStringToList() {

        val result=TypeConversionUtils.mapSeparateStringToList("This;is;String;Test");

        assertNotNull(result);
        assertEquals(result, List.of("This", "is", "String", "Test"));
    }

    @Test
    void should_mapSeparateStringToList_return_empty_list() {

        val result=TypeConversionUtils.mapSeparateStringToList((String) null);

        assertNotNull(result);
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void testMapSeparateStringToList() {

        val result=TypeConversionUtils.mapSeparateStringToList(List.of("This", "is", "String", "Test"));

        assertNotNull(result);
        assertEquals(result,"This;is;String;Test");
    }

    @Test
    void should_testMapSeparateStringToList_return_null() {

        val result=TypeConversionUtils.mapSeparateStringToList((List<String>) null);

        assertNull(result);
        assertEquals(result,null);
    }
}