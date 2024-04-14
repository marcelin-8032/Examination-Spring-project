package com.examination.project.utils.comparator;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(fluent = true)
public class FieldComparatorCriteria {

    @Setter(value = AccessLevel.NONE)
    private List<String> criterion;




}
