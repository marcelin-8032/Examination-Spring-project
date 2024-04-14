package com.examination.project.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MockMvc;

@FunctionalInterface
public interface EmptyMvcBinder {

    void with(MockMvc mvc, ObjectMapper objectMapper);
}
