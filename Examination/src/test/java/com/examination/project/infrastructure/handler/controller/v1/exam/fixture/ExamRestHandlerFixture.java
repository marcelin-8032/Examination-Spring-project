package com.examination.project.infrastructure.handler.controller.v1.exam.fixture;

import com.examination.project.domain.entities.Exam;
import com.examination.project.infrastructure.handler.controller.utils.MvcBinder;
import com.examination.project.utils.MockMvcUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.collection.List;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static com.examination.project.utils.ModelFactory.defaultExam;
import static com.examination.project.utils.ModelFactory.defaultExams;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ExamRestHandlerFixture extends MockMvcUtils {

    private final String EXAM_URL = "/v1/exams";

    protected ExamRestHandlerFixture(MockMvc mockMvc, ObjectMapper objectMapper) {
        super(mockMvc, objectMapper);
    }

    public static ExamRestHandlerFixture from(MockMvc mockMvc, ObjectMapper objectMapper) {
        return new ExamRestHandlerFixture(mockMvc, objectMapper);
    }

    public ResultActions addExam() {

        try {
            return mockMvc.perform(post(EXAM_URL + "/add")
                            .contentType(APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(defaultExam().withExamDate(LocalDateTime.parse("2024-07-16T17:50:50")))))
                    .andDo(print());

        } catch (Exception e) {
            throw new AssertionError("should not have thrown any exception", e);
        }
    }

    public ResultActions addListExams() {

        try {
            return mockMvc.perform(post(EXAM_URL + "/addExams")
                            .contentType(APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(defaultExams())))
                    .andDo(print());
        } catch (Exception e) {
            throw new AssertionError("should not have thrown any exception", e);
        }
    }

    public MvcBinder<List<Exam>> getAllExams() {

        return (mvc, objectMapper1) -> {
            try {
                val resultActions = mockMvc.perform(MockMvcRequestBuilders
                        .get(EXAM_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk());

                val result = resultActions.andReturn();
                val contentAsString = result.getResponse().getContentAsString();
                return objectMapper.readValue(contentAsString, new TypeReference<List<Exam>>() {
                });

            } catch (Exception e) {
                throw new AssertionError("should not have thrown any exception", e);
            }
        };
    }

    public Page<Exam> getAllExamsByRoom() {

        try {
            val resultActions = mockMvc.perform(MockMvcRequestBuilders.get(EXAM_URL + "/examPages/" + "/1")
                            .param("page", "0")
                            .param("size", "3")
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON));

            val result = resultActions.andReturn();
            val contentAsString = result.getResponse().getContentAsString();
            return objectMapper.readValue(contentAsString, new TypeReference<>() {
            });
        } catch (Exception e) {
            throw new AssertionError("should not have thrown any exception", e);
        }
    }

    public MvcBinder<List<Exam>> getExamsByDate() {

        try {
            return (mvc, objectMapper1) -> {
                try {
                    val resultActions = mockMvc.perform(MockMvcRequestBuilders
                            .get(EXAM_URL + "/date/" + "2023-07-29T14:49:41")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                    ).andExpect(status().isOk());

                    val result = resultActions.andReturn();
                    val contentAsString = result.getResponse().getContentAsString();
                    return objectMapper.readValue(contentAsString, new TypeReference<List<Exam>>() {
                    });

                } catch (Exception e) {
                    throw new AssertionError("should not have thrown any exception", e);
                }
            };
        } catch (Exception e) {
            throw new AssertionError("should not have thrown any exception", e);
        }
    }

    public MvcResult deleteAllExams() {

        try {
            return mockMvc.perform(delete(EXAM_URL + "/delete-all"))
                    .andExpect(status().isNoContent())
                    .andReturn();

        } catch (Exception exception) {
            throw new AssertionError("thrown exception", exception);
        }
    }

    public MvcBinder<List<Exam>> getExamsAssignedToSpecificStudent() {

        return (mvc, objectMapper) -> {
            try {

                val resultActions = mockMvc.perform(get(EXAM_URL + "/1" + "/exams")
                                .accept(MediaType.APPLICATION_JSON)
                        ).andExpect(status().isOk())
                        .andDo(print());

                val result = resultActions.andReturn();
                val contentAsString = result.getResponse().getContentAsString();

                return objectMapper.readValue(contentAsString, new TypeReference<List<Exam>>() {
                });

            } catch (Exception e) {
                throw new AssertionError("should not have thrown any exception", e);
            }
        };
    }

/*

    public List<Exam> getExamsAtRoomAndAfterADate() {

        try {


        } catch (Exception e) {
            throw new AssertionError("should not have thrown any exception", e);
        }


    }

    public List<Exam>  getExamsAtRecentDataAtSpecificRoom(){

        try {


        } catch (Exception e) {
            throw new AssertionError("should not have thrown any exception", e);
        }

    }

    public Page<Exam> getAllExamsInPages() {

        try {


        } catch (Exception e) {
            throw new AssertionError("should not have thrown any exception", e);
        }

    }
*/

}
