package com.examination.project.utils.page;

import org.springframework.data.domain.Page;

public record PageCriteria(int offset, int limit) {

    public static final int MAX_LIMIT = 1000;

    public PageCriteria() {
        this(0, 10);
    }

    public PageCriteria {

        if (limit < 1 || limit > MAX_LIMIT) {
            throw new IllegalArgumentException("limit value must between 1 and " + MAX_LIMIT);
        }

        if (offset < 0) {
            throw new IllegalArgumentException("offset value must be a positive integer");
        }
    }

    public static PageCriteria max() {
        return new PageCriteria(0, MAX_LIMIT);
    }
}
