package com.examination.project.utils.functional;

import io.vavr.control.Option;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CollectionFunctionalUtils {

    public static <T, R> List<R> map(Collection<T> collection, Function<T, R> map) {

        return Option.of(collection)
                .filter(CollectionUtils::isNotEmpty)
                .map(o -> o.stream().map(map).toList())
                .getOrNull();
    }


    public static <T> List<T> filter(Collection<T> collection, Predicate<T> filter) {

        return Option.of(collection)
                .filter(CollectionUtils::isNotEmpty)
                .map(o -> o.stream().filter(filter).toList())
                .getOrElse(List::of);
    }

    public static <T> Option<T> findFirst(Collection<T> collection) {

        return findFirst(collection, t -> true);
    }

    public static <T> Option<T> findFirst(Collection<T> collection, Predicate<T> tPredicate) {

        return Option.of(collection).flatMap(y -> Option.ofOptional(y.stream().filter(tPredicate).findFirst()));
    }

    public static <T> Option<T> findMax(Collection<T> collection, Comparator<T> comparator) {

        return Option.of(collection).flatMap(y -> Option.ofOptional(y.stream().max(comparator)));
    }

    public static <T> boolean allMatch(Collection<T> collection, Predicate<T> tPredicate) {

        return Option.of(collection)
                .map(y -> y.stream().allMatch(tPredicate))
                .getOrElse(false);
    }

    public static <T, R> boolean allMatch(Map<T, R> collection, Predicate<Map.Entry<T, R>> entryPredicate) {

        return Option.of(collection)
                .map(y -> y.entrySet().stream().allMatch(entryPredicate))
                .getOrElse(false);
    }

    public static <T, R> Option<Map.Entry<T, R>> findFirst(Map<T, R> collection, Predicate<Map.Entry<T, R>> entryPredicate) {

        return Option.of(collection)
                .flatMap(y -> Option.ofOptional(y.entrySet()
                        .stream()
                        .filter(entryPredicate)
                        .findFirst()));
    }
}
