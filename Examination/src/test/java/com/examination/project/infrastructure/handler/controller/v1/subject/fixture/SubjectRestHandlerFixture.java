package com.examination.project.infrastructure.handler.controller.v1.subject.fixture;

import com.examination.project.domain.entities.Subject;
import com.examination.project.domain.fixture.SubjectFixture;
import com.examination.project.infrastructure.handler.utils.MockMvcUtils;
import com.examination.project.infrastructure.handler.utils.MvcBinder;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.collection.List;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SubjectRestHandlerFixture extends MockMvcUtils {

    private static final String SUBJECT_URL = "/v1/subjects";

    protected SubjectRestHandlerFixture(MockMvc mockMvc, ObjectMapper objectMapper) {
        super(mockMvc, objectMapper);
    }

    public static SubjectRestHandlerFixture from(MockMvc mockMvc, ObjectMapper objectMapper) {
        return new SubjectRestHandlerFixture(mockMvc, objectMapper);
    }


    public static MvcBinder<Subject> createSubject() {

       var subject = SubjectFixture.one();

        return (mockMvc, objectMapper) -> {

            try {
                final ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                                .post(SUBJECT_URL + "/create")
                                .contentType(APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(subject)))
                                .andExpect(status().isCreated());

                final MvcResult result = resultActions.andReturn();
                final String contentAsString = result.getResponse().getContentAsString();

                return objectMapper.readValue(contentAsString, Subject.class);

            } catch (Exception exception) {
                throw new AssertionError("thrown exception", exception);
            }
        };
    }


    public static MvcBinder<List<Subject>> getAllSubjects() {

        return (mvc, objectMapper) -> {
            try {
                final ResultActions resultActions = mvc.perform(MockMvcRequestBuilders
                                .get(SUBJECT_URL)
                                .contentType(APPLICATION_JSON)
                                .accept(APPLICATION_JSON))
                        .andExpect(status().isOk());

                final MvcResult result = resultActions.andReturn();
                final String contentAsString = result.getResponse().getContentAsString();
                return objectMapper.readValue(contentAsString, new TypeReference<List<Subject>>() {
                });

            } catch (Exception exception) {
                throw new AssertionError("thrown exception", exception);
            }
        };

    }
}
