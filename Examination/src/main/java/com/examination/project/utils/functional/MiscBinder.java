package com.examination.project.utils.functional;


import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class MiscBinder {

    public static <T> void bindToMyPage(List<T> toBind, int pageSize, Consumer<List<T>> binder) {

        IntStream.range(0, (toBind.size() + pageSize - 1) / pageSize)
                .mapToObj(i -> toBind
                        .subList(i * pageSize, Math.min(pageSize * (i + 1), toBind.size())))
                .forEach(binder);

    }

}
