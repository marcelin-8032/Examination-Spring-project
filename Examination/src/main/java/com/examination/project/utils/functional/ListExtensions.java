package com.examination.project.utils.functional;


import io.vavr.Tuple;
import io.vavr.Tuple2;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

@UtilityClass
public class ListExtensions {

    public static <I, O> List<Tuple2<O, O>> toZip(@NonNull I col1,
                                                  @NonNull I col2,
                                                  @NonNull Function<I, List<O>> fn
    ) {

        var s1 = fn.apply(col1);
        var s2 = fn.apply(col2);

        return IntStream.range(0, Math.min(s1.size(), s2.size()))
                .mapToObj(i -> Tuple.of(s1.get(i), s2.get(i)))
                .toList();
    }

    public static <I> void peek(List<I> col, Consumer<I> consumer) {

        col.forEach(consumer);
    }

    public static <T> List<T> filter(List<T> collection, Predicate<T> predicate) {

        return collection.stream().filter(predicate).toList();
    }

    public static <T, O> List<O> map(List<T> collection, Function<T, O> fn) {

        return collection.stream().map(fn).toList();
    }
}
