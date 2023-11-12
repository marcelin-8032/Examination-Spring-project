package com.examination.project.infrastructure.handler.controller.v1.subject.fixture;

import com.examination.project.domain.entities.Subject;
import com.examination.project.infrastructure.handler.controller.utils.MockMvcUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.collection.List;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SubjectRestHandlerFixture extends MockMvcUtils {

    private final String SUBJECT_URL = "v1/subjects";

    protected SubjectRestHandlerFixture(MockMvc mockMvc, ObjectMapper objectMapper) {
        super(mockMvc, objectMapper);
    }

    public static SubjectRestHandlerFixture from(MockMvc mockMvc, ObjectMapper objectMapper) {
        return new SubjectRestHandlerFixture(mockMvc, objectMapper);
    }

    public List<Subject> getAllSubjects() {
        try {
            final ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                            .get(SUBJECT_URL)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());

            final MvcResult result = resultActions.andReturn();
            final String contentAsString = result.getResponse().getContentAsString();
            return objectMapper.readValue(contentAsString, new TypeReference<>() {
            });

        } catch (Exception exception) {
            throw new AssertionError("thrown exception", exception);
        }
    }


}
