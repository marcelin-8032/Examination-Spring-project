package com.examination.project.utils.functional;


import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

@UtilityClass
public class StringExtensions {

    public static String[] toArray(String value, boolean condition, @NonNull String separator) {
        return condition ? StringUtils.trimToEmpty(value).split(separator) : new String[]{value};
    }
}
