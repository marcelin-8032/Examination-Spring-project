package com.examination.project.infrastructure.handler.controller.v1.subject.fixture;

import com.examination.project.domain.entities.Subject;
import com.examination.project.infrastructure.handler.controller.utils.MvcBinder;
import com.examination.project.utils.MockMvcUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.collection.List;
import lombok.val;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.examination.project.utils.ModelFactory.defaultSubject;
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

    public ResultActions createSubject() {

        try {

            return mockMvc.perform(MockMvcRequestBuilders
                    .post(SUBJECT_URL + "/create")
                    .contentType(APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(defaultSubject())));

        } catch (Exception exception) {
            throw new AssertionError("should not have thrown any exception", exception);
        }
    }

    public ResultActions updateSubjectCoefficient() {

        try {

            return mockMvc.perform(MockMvcRequestBuilders
                    .put(SUBJECT_URL + "/update" + "/1")
                    .param("coefficient", "164")
                    .contentType(APPLICATION_JSON));

        } catch (Exception exception) {
            throw new AssertionError("should not have thrown any exception", exception);
        }
    }

    public MvcBinder<List<Subject>> getSubjectByCoeffBiggerThan() {

        return (mvc, objectMapper) -> {
            try {
                val resultActions = mvc.perform(MockMvcRequestBuilders
                                .get(SUBJECT_URL + "/subjectByCoeff")
                                .param("coeff", "164")
                                .contentType(APPLICATION_JSON)
                                .accept(APPLICATION_JSON))
                        .andExpect(status().isOk());

                val result = resultActions.andReturn();
                val contentAsString = result.getResponse().getContentAsString();
                return objectMapper.readValue(contentAsString, new TypeReference<List<Subject>>() {
                });

            } catch (Exception exception) {
                throw new AssertionError("should not have thrown any exception", exception);
            }
        };
    }

    public static MvcBinder<List<Subject>> getAllSubjects() {

        return (mvc, objectMapper) -> {
            try {
                val resultActions = mvc.perform(MockMvcRequestBuilders
                                .get(SUBJECT_URL)
                                .contentType(APPLICATION_JSON)
                                .accept(APPLICATION_JSON))
                        .andExpect(status().isOk());


                val result = resultActions.andReturn();
                val contentAsString = result.getResponse().getContentAsString();
                return objectMapper.readValue(contentAsString, new TypeReference<List<Subject>>() {
                });

            } catch (Exception exception) {
                throw new AssertionError("should not have thrown any exception", exception);
            }
        };
    }

    public static MvcBinder<List<Subject>> getSubjectByCoeffBiggerThanAndTitleDataAndModule() {

        return (mvc, objectMapper) -> {
            try {
                val resultActions = mvc.perform(MockMvcRequestBuilders
                                .get(SUBJECT_URL + "/coeff" + "/164" + "/subjectModule" + "/MODULE_2" + "/title=Chemistry")
                                .contentType(APPLICATION_JSON)
                                .accept(APPLICATION_JSON))
                        .andExpect(status().isOk());


                val result = resultActions.andReturn();
                val contentAsString = result.getResponse().getContentAsString();
                return objectMapper.readValue(contentAsString, new TypeReference<List<Subject>>() {
                });

            } catch (Exception exception) {
                throw new AssertionError("should not have thrown any exception", exception);
            }
        };
    }

    public static MvcBinder<List<Subject>> getSubjectByCoeffBiggerThanAndModule() {

        return (mvc, objectMapper) -> {
            try {
                val resultActions = mvc.perform(MockMvcRequestBuilders
                                .get(SUBJECT_URL + "/coeff" + "/164" + "/subjectModule" + "/MODULE_2")
                                .contentType(APPLICATION_JSON)
                                .accept(APPLICATION_JSON))
                        .andExpect(status().isOk());


                val result = resultActions.andReturn();
                val contentAsString = result.getResponse().getContentAsString();
                return objectMapper.readValue(contentAsString, new TypeReference<List<Subject>>() {
                });

            } catch (Exception exception) {
                throw new AssertionError("should not have thrown any exception", exception);
            }
        };
    }

    public static MvcBinder<List<Subject>> getSubjectTitleDataAndModuleEq2() {

        return (mvc, objectMapper) -> {
            try {
                val resultActions = mvc.perform(MockMvcRequestBuilders
                                .get(SUBJECT_URL + "/subjectModule" + "/MODULE_3")
                                .contentType(APPLICATION_JSON)
                                .accept(APPLICATION_JSON))
                        .andExpect(status().isOk());


                val result = resultActions.andReturn();
                val contentAsString = result.getResponse().getContentAsString();
                return objectMapper.readValue(contentAsString, new TypeReference<List<Subject>>() {
                });

            } catch (Exception exception) {
                throw new AssertionError("should not have thrown any exception", exception);
            }
        };
    }

    public static MvcBinder<Subject> getSubjectByExample() {

        return (mvc, objectMapper) -> {
            try {
                val resultActions = mvc.perform(MockMvcRequestBuilders
                                .get(SUBJECT_URL + "/subjectByExp")
                                .contentType(APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(Subject.builder().build()))
                                .accept(APPLICATION_JSON))
                        .andExpect(status().isFound());

                val result = resultActions.andReturn();
                val contentAsString = result.getResponse().getContentAsString();
                return objectMapper.readValue(contentAsString, Subject.class);

            } catch (Exception exception) {
                throw new AssertionError("should not have thrown any exception", exception);
            }
        };
    }

    public static MvcBinder<List<Subject>> getSubjectByExampleCoeffAndTitle() {

        return (mvc, objectMapper) -> {
            try {
                val resultActions = mvc.perform(MockMvcRequestBuilders
                                .get(SUBJECT_URL + "/subjectByExpCoeffAndTitle")
                                .contentType(APPLICATION_JSON)
                                .param("title", "Physics")
                                .param("coefficient", "164")
                                .accept(APPLICATION_JSON))
                        .andExpect(status().isOk());

                val result = resultActions.andReturn();
                val contentAsString = result.getResponse().getContentAsString();
                return objectMapper.readValue(contentAsString, new TypeReference<List<Subject>>() {
                });

            } catch (Exception exception) {
                throw new AssertionError("should not have thrown any exception", exception);
            }
        };
    }

    public static MvcBinder<List<Subject>> getSubjectByTitleWithIgnoreCase() {

        return (mvc, objectMapper) -> {
            try {
                val resultActions = mvc.perform(MockMvcRequestBuilders
                                .get(SUBJECT_URL + "/subjectByExpTitleIgnoreCase")
                                .contentType(APPLICATION_JSON)
                                .param("title", "Physics")
                                .accept(APPLICATION_JSON))
                        .andExpect(status().isOk());

                val result = resultActions.andReturn();
                val contentAsString = result.getResponse().getContentAsString();
                return objectMapper.readValue(contentAsString, new TypeReference<List<Subject>>() {
                });

            } catch (Exception exception) {
                throw new AssertionError("should not have thrown any exception", exception);
            }
        };
    }
}
