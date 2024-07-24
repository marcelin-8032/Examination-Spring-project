package com.examination.project.infrastructure.handler.controller.v1.student.fixture;

import com.examination.project.domain.entities.Student;
import com.examination.project.infrastructure.handler.controller.utils.MvcBinder;
import com.examination.project.utils.MockMvcUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.collection.List;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.examination.project.utils.ModelFactory.defaultStudent;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
public class StudentRestHandlerFixture extends MockMvcUtils {

    private static final String STUDENT_URL = "/v1/students";

    protected StudentRestHandlerFixture(MockMvc mockMvc, ObjectMapper objectMapper) {
        super(mockMvc, objectMapper);
    }

    public static StudentRestHandlerFixture from(MockMvc mockMvc, ObjectMapper objectMapper) {
        return new StudentRestHandlerFixture(mockMvc, objectMapper);
    }

    public MvcBinder<Student> createStudent() {

        return (mockMvc, objectMapper) -> {

            try {
                val resultActions = mockMvc.perform(MockMvcRequestBuilders
                                .post(STUDENT_URL + "/create")
                                .contentType(APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(defaultStudent())))
                        .andExpect(status().isCreated());

                val result = resultActions.andReturn();
                val contentAsString = result.getResponse().getContentAsString();

                return objectMapper.readValue(contentAsString, new TypeReference<Student>() {
                });

            } catch (Exception exception) {
                throw new AssertionError("should not have thrown any exception", exception);
            }
        };
    }
    
    public MvcBinder<List<Student>> getAllStudents() {

        return (mvc, objectMapper) -> {
            try {

                val resultActions = mockMvc.perform(get(STUDENT_URL)
                        .accept(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk());

                val result = resultActions.andReturn();
                val contentAsString = result.getResponse().getContentAsString();

                return objectMapper.readValue(contentAsString, new TypeReference<List<Student>>() {
                });

            } catch (Exception e) {
                throw new AssertionError("should not have thrown any exception", e);
            }
        };
    }
}
