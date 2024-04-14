package com.examination.project.infrastructure.handler.controller.utils;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import static com.examination.project.domain.usecases.v2.UseCase.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HandlerResponse {

    public static <T> ResponseEntity<T> toOk(Result result) {
        return ResponseEntity.ok((T) result.data());
    }




}
