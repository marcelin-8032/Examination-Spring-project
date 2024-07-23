package com.examination.project.infrastructure.handler.controller.v1.student.fixture;

import com.examination.project.infrastructure.handler.controller.v1.subject.fixture.SubjectRestHandlerFixture;
import com.examination.project.utils.MockMvcUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MockMvc;

public class StudentRestHandlerFixture extends MockMvcUtils {

    private static final String STUDENT_URL = "/v1/students";

    protected StudentRestHandlerFixture(MockMvc mockMvc, ObjectMapper objectMapper) {
        super(mockMvc, objectMapper);
    }

    public static StudentRestHandlerFixture from(MockMvc mockMvc, ObjectMapper objectMapper) {
        return new StudentRestHandlerFixture(mockMvc, objectMapper);
    }

    //TODO
}
