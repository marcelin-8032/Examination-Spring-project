package com.examination.project.utils.functional;


import io.vavr.control.Option;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.util.stream.Collectors.toSet;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ConditionalMapper {

    public static <T> void notNullOrEmpty(Set<T> values, Consumer<Set<T>> bindTo) {

        Optional.ofNullable(values)
                .filter(CollectionUtils::isNotEmpty)
                .ifPresent(bindTo);

    }

    public static <T, R> void notNullOrEmpty(Set<T> values, Consumer<Set<R>> bindTo, Function<T, R> convert) {

        Function<Set<T>, Set<R>> iterate = ts -> ts.stream().map(convert).collect(toSet());

        Optional.ofNullable(values)
                .filter(CollectionUtils::isNotEmpty).map(iterate)
                .ifPresent(bindTo);

    }

    public static <T, R> void notNullOrEmptyWithDefault(Set<T> values, Consumer<Set<R>> bindTo,
                                                        Set<R> defaultValue,
                                                        Function<T, R> convert) {

        Function<Set<T>, Set<R>> iterate = ts -> ts.stream().map(convert).collect(toSet());

        Optional.ofNullable(values)
                .filter(CollectionUtils::isNotEmpty).map(iterate)
                .ifPresentOrElse(bindTo, () -> bindTo.accept(defaultValue));

    }

    public static <T, R> Consumer<Set<R>> notNullOrEmptyReplace(Set<T> values, Function<T, R> convert) {

        Function<Set<T>, Set<R>> iterate = ts -> ts.stream().map(convert).collect(toSet());

        return source -> Optional.ofNullable(values)
                .filter(CollectionUtils::isNotEmpty)
                .map(iterate)
                .ifPresent(source::addAll);

    }

    public static <T, R> void notNull(T value, Consumer<R> bindTo, Function<T, R> convert) {

        Optional.ofNullable(value)
                .map(convert)
                .ifPresent(bindTo);
    }

    public static <T> void notNull(T value, Consumer<T> bindTo) {

        Optional.ofNullable(value)
                .ifPresent(bindTo);
    }


    public static <T, R> void notNullWithDefault(T value, R defaultValue, Consumer<R> bindTo, Function<T, R> convert) {

        Objects.requireNonNull(defaultValue);

        Option.of(value).map(convert).orElse(() -> Option.of(defaultValue)).peek(bindTo);
    }

    public static <T> void notNullWithDefault(T value, T defaultValue, Consumer<T> bindTo) {

        Objects.requireNonNull(defaultValue);

        Option.of(value).orElse(() -> Option.of(defaultValue)).peek(bindTo);
    }

    public static <T> void notNullWithDefault(T value, T defaultValue) {

        Objects.requireNonNull(defaultValue);

        Option.of(value).getOrElse(() -> defaultValue);
    }

    public static <T> void conditionalCheck(BooleanSupplier supplier, T value, Consumer<T> consumer) {
        if (supplier.getAsBoolean()) {
            consumer.accept(value);
        }
    }
}
