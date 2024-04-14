package com.examination.project.utils.comparator;


import com.examination.project.utils.functional.ListExtensions;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.ExtensionMethod;

import java.lang.reflect.Field;

@Data
@Accessors(fluent = true)
@RequiredArgsConstructor
@ExtensionMethod({ListExtensions.class})
public class ComparableFieldWrapper<T> {

   // private final List<Field<T>> fields;


}
