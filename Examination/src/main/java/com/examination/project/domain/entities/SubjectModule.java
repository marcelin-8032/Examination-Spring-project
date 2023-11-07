package com.examination.project.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@Accessors(fluent = true)
@AllArgsConstructor(access = PRIVATE)
//@ToString
public enum SubjectModule {

    MODULE_1 ("Module1"),
    MODULE_2 ("Module2"),
    MODULE_3 ("Module3");

    @Getter
    private String message;

}
