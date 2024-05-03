package com.examination.project.utils.misc;


import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class TypeConversionUtils {

    private static final String NAME_LIST_SEPARATOR = ";";

    public static List<String> mapSeparateStringToList(String value) {

        return Optional.ofNullable(value)
                .filter(it -> it.length() > 0)
                .map(it -> it.split(NAME_LIST_SEPARATOR))
                .map(List::of)
                .orElse(Collections.emptyList());
    }

    public static String mapSeparateStringToList(List<String> value) {

        return Objects.isNull(value) ? null : String.join(NAME_LIST_SEPARATOR, value);
    }

}
