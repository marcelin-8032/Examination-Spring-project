package com.examination.project.utils.functional;


import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class EnumBinder {

    public static <T extends Enum<T>> Map<String, T> bindTo(Class<T> value) {

        final Function<T, String> toUpperCase = t -> t.name().toUpperCase();

        return Arrays.stream(value.getEnumConstants()).collect(Collectors.toMap(toUpperCase, Function.identity()));
    }

    public static <R, T extends Enum<T>> Map<R, T> bindTo(Class<T> value, Function<T, R> linkedWith) {

        return Arrays.stream(value.getEnumConstants()).collect(Collectors.toMap(linkedWith, Function.identity()));
    }

}
