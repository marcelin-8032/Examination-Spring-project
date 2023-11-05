package com.examination.project.utils;


import lombok.NoArgsConstructor;

import java.security.SecureRandom;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class EnumTools {
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
    public static <T extends Enum<?>> T randomEnum(Class<T> tClass) {

        int nX = SECURE_RANDOM.nextInt(tClass.getEnumConstants().length);
        return tClass.getEnumConstants()[nX];
    }
}
