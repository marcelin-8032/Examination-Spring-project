package com.examination.project.utils.comparator;

import java.util.function.Function;

public record Field<T>(String name, int order, Function<T, String> converter)
        implements Function<T, String>, Comparable<Field<T>> {


    public Field(String name, Function<T, String> converter) {
        this(name, 0, converter);
    }

    @Override
    public String apply(T t) {
        return this.converter.apply(t);
    }

    @Override
    public int compareTo(Field<T> o) {
        return Integer.compare(this.order, o.order);
    }

}
