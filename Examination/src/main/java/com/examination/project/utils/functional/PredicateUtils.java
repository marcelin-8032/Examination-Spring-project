package com.examination.project.utils.functional;


import lombok.experimental.UtilityClass;

import java.util.function.Function;
import java.util.function.Supplier;

@UtilityClass
public class PredicateUtils {

    public static <U> Function<Boolean, U> fold(Supplier<? extends U> ifFalse, Supplier<? extends U> ifTrue) {

        return e -> e ? ifTrue.get() : ifFalse.get();
    }
}
