package com.examination.project.utils.functional;


import io.vavr.Function2;
import io.vavr.Function3;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

@UtilityClass
public final class NullUtils {

    public static <I> void acceptIfNotNull(Consumer<I> fun, I value) {
        if (value != null) {
            fun.accept(value);
        }
    }

    public static <I, V> void acceptIfNotNull(Consumer<I> fun, V value, Function<V, I> converter) {
        if (value != null) {
            acceptIfNotNull(fun, converter.apply(value));
        }
    }

    public static <I, V, V2> void acceptNotNull(Consumer<I> iConsumer, V value, V2 value2, Function2<V, V2, I> converter) {
        if (value != null) {
            acceptIfNotNull(iConsumer, converter.apply(value, value2));
        }
    }

    public static <I, R> R ifConditionAndNotNull(Predicate<I> predicate, I value, Function<I, R> function) {
        return value != null && predicate.test(value) ? ifNotNull(function, value) : null;
    }

    public static <I, R> R ifNotNull(Function<I, R> function, I value) {
        return value != null ? function.apply(value) : null;
    }

    public static <I, R, K> K ifNotNull(BiFunction<I, R, K> biFunction, I value, R value1) {
        return value != null && value1 != null ? biFunction.apply(value, value1) : null;
    }

    public static <I, R, K> K ifNotNullOr(BiFunction<I, R, K> biFunction, I value, R value1, @NotNull K defaultValue) {
        return value != null && value1 != null ? biFunction.apply(value, value1) : defaultValue;
    }

    public static <I, R> R ifNotNullOr(Function<I, R> function, I value, @NotNull R value2) {
        return value != null ? function.apply(value) : value2;
    }


    public static <I, V, V2> void acceptIfNotNull(Consumer<I> consumer, V value, V2 value2, Function2<V, V2, I> function2) {
        if (value != null) {
            acceptIfNotNull(consumer, function2.apply(value, value2));
        }
    }

    public static <I, V, V2, V3> void acceptIfNot(Consumer<I> consumer, V value, V2 value2, V3 value3, Function3<V, V2, V3, I> converter) {
        if (value != null) {
            acceptIfNotNull(consumer, converter.apply(value, value2, value3));
        }
    }

    public static <I, I2, V> void acceptIfNotNull(Consumer<I2> consumer, V value,
                                                  Function<V, I> converter,
                                                  Function<I, I2> converter2) {
        if (value != null) {
            acceptIfNotNull(consumer, converter2.apply(converter.apply(value)));
        }
    }

    public static <I, I2, V, V2> void acceptIfNotNull(Consumer<I2> consumer, V value, V2 value2,
                                                      Function2<V, V2, I> converter,
                                                      Function<I, I2> converter2) {
        if (value != null) {
            acceptIfNotNull(consumer, converter2.apply(converter.apply(value, value2)));
        }
    }

    public static <T> Optional<T> findFirst(java.util.List<T> list) {
        return NullUtils.ifNotNullOr(v -> v.stream().findFirst(), list, Optional.empty());
    }

    public static boolean eval(Boolean value) {
        return Boolean.TRUE.equals(value);
    }

    public static String emptyStringIfNull(String str) {
        return Optional.ofNullable(str).orElse("");
    }

    public static String nullIfEmptyString(String str) {
        return StringUtils.isBlank(str) ? null : str;
    }

    public static <T> Stream<T> evalOrEmpty(Collection<T> collection) {
        return Optional.ofNullable(collection).stream().flatMap(Collection::stream);
    }

}
