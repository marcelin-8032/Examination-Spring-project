package com.examination.project.infrastructure.handler.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MockMvc;

@FunctionalInterface
public interface MvcBinder<R> {

    R with(MockMvc mvc, ObjectMapper objectMapper);

}
