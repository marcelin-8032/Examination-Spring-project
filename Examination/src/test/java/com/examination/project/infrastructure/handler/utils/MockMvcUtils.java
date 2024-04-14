package com.examination.project.infrastructure.handler.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MockMvc;

public class MockMvcUtils {

    protected final MockMvc mockMvc;
    protected final ObjectMapper objectMapper;

    protected MockMvcUtils(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
    }
}
