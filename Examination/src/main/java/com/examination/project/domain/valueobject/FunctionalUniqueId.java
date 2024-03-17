package com.examination.project.domain.valueobject;


import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public abstract class FunctionalUniqueId {

    @Getter
    private final Integer id;

    protected FunctionalUniqueId(Integer id) {
        this.id = id;
    }

    public abstract boolean isValid();
}
