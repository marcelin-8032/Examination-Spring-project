package com.examination.project.infrastructure.handler.controller.v1.invigilator.fixture;

import com.examination.project.domain.entities.Invigilator;
import com.examination.project.domain.fixture.InvigilatorFixture;
import com.examination.project.infrastructure.handler.utils.MockMvcUtils;
import com.examination.project.infrastructure.handler.utils.MvcBinder;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.collection.List;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.lang.reflect.Type;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class InvigilatorRestHandlerFixture extends MockMvcUtils {

    private static final String INVIGILATOR_URL = "/v1/" + "invigilators";

    protected InvigilatorRestHandlerFixture(MockMvc mockMvc, ObjectMapper objectMapper) {
        super(mockMvc, objectMapper);
    }

    public static InvigilatorRestHandlerFixture from(MockMvc mockMvc, ObjectMapper objectMapper) {
        return new InvigilatorRestHandlerFixture(mockMvc, objectMapper);
    }

    public MvcBinder<ResponseEntity<Void>> createInvigilator() {

        var invigilator = InvigilatorFixture.one();

        return (mvc, objectMapper) -> {

            try {
                final ResultActions resultActions = mockMvc.perform(post(INVIGILATOR_URL + "/create")
                                .contentType(APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(invigilator)))
                        .andExpect(status().isCreated());

                final MvcResult result = resultActions.andReturn();
                final String contentAsString = result.getResponse().getContentAsString();
                return objectMapper.readValue(contentAsString, new TypeReference<>() {
                });

            } catch (Exception exception) {
                throw new AssertionError("thrown exception", exception);
            }
        };
    }


    public MvcBinder<List<Invigilator>> getAllInvigilators() {

        return (mvc, objectMapper) -> {
            try {
                final ResultActions resultActions = mockMvc.perform(get(INVIGILATOR_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk());

                final MvcResult result = resultActions.andReturn();
                final String contentAsString = result.getResponse().getContentAsString();

                return objectMapper.readValue(contentAsString, new TypeReference<List<Invigilator>>() {
                });

            } catch (Exception e) {
                throw new AssertionError("should not have thrown any exception", e);
            }

        };

    }

    public MvcBinder<ResponseEntity<Void>> deleteInvigilatorById() {

        return (mvc, objectMapper) -> {
            try {
                mockMvc.perform(delete(INVIGILATOR_URL + "1"))
                        .andExpect(status().isOk())
                        .andDo(print());
        /*    val result = resultActions.andReturn();
            val contentAsString = result.getResponse().getContentAsString();
            objectMapper.readValue(contentAsString, Invigilator.class);*/
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception exception) {
                throw new AssertionError("thrown exception", exception);

            }
        };
    }


    public MvcBinder<ResponseEntity<Void>> deleteAllInvigilator() {

        return (mvc, objectMapper) -> {
            try {
                mockMvc.perform(delete(INVIGILATOR_URL + "/deleteAll"))
                        .andExpect(status().isOk())
                        .andDo(print());

        /*    val result = resultActions.andReturn();
            val contentAsString = result.getResponse().getContentAsString();
            objectMapper.readValue(contentAsString, Invigilator.class);*/
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception exception) {
                throw new AssertionError("thrown exception", exception);
            }
        };
    }


}

