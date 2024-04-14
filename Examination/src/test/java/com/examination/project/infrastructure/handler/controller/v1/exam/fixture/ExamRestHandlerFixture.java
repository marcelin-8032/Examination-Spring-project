package com.examination.project.infrastructure.handler.controller.v1.exam.fixture;

import com.examination.project.domain.entities.Exam;
import com.examination.project.infrastructure.handler.utils.MockMvcUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.collection.List;
import lombok.val;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ExamRestHandlerFixture extends MockMvcUtils {

    private final String EXAM_URL = "/v2/exams";

    protected ExamRestHandlerFixture(MockMvc mockMvc, ObjectMapper objectMapper) {
        super(mockMvc, objectMapper);
    }

    public static ExamRestHandlerFixture from(MockMvc mockMvc, ObjectMapper objectMapper) {
        return new ExamRestHandlerFixture(mockMvc, objectMapper);
    }


    public List<Exam> getAllExams() {
        try {

            val resultActions = mockMvc.perform(MockMvcRequestBuilders
                    .get(EXAM_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
            ).andExpect(status().isOk());

            val result = resultActions.andReturn();
            val contentAsString = result.getResponse().getContentAsString();
            return objectMapper.readValue(contentAsString, new TypeReference<>() {
            });

        } catch (Exception e) {
            throw new AssertionError("should not have thrown any exception", e);
        }

    }


}
