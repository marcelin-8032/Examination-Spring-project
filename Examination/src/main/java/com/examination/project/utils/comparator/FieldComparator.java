package com.examination.project.utils.comparator;


import com.examination.project.utils.functional.ListExtensions;
import lombok.Data;
import lombok.experimental.ExtensionMethod;

import java.util.Objects;

@Data
@ExtensionMethod({ListExtensions.class})
public class FieldComparator<T> implements Comparable<T> {

    private final FieldComparatorCriteria fieldComparatorCriteria;

    private final ComparableFieldWrapper<T> comparableFieldWrapper;

    public FieldComparator(FieldComparatorCriteria fieldComparatorCriteria, ComparableFieldWrapper<T> comparableFieldWrapper) {
        this.fieldComparatorCriteria = Objects.requireNonNull(fieldComparatorCriteria);
        this.comparableFieldWrapper =Objects.requireNonNull(comparableFieldWrapper);
    }

    public int compareTo(T o1, T o2) {
        return 0;
    }

    @Override
    public int compareTo(T o) {
        return 0;
    }
}
