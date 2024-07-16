package com.examination.project.infrastructure.handler.controller.v1.invigilator.fixture;

import com.examination.project.domain.entities.Invigilator;
import com.examination.project.utils.MockMvcUtils;
import com.examination.project.infrastructure.handler.controller.utils.MvcBinder;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.collection.List;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static com.examination.project.utils.ModelFactory.defaultInvigilator;
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

    public ResultActions createInvigilator() {

        try {
            return mockMvc.perform(post(INVIGILATOR_URL + "/create")
                            .contentType(APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(defaultInvigilator())))
                    .andDo(print());

        } catch (Exception exception) {
            throw new AssertionError("thrown exception", exception);
        }
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

    public MvcResult deleteInvigilatorById() {

        try {
            return mockMvc
                    .perform(delete(INVIGILATOR_URL + "/1"))
                    .andDo(print())
                    .andReturn();

        } catch (Exception exception) {
            throw new AssertionError("thrown exception", exception);
        }
    }

    public MvcResult deleteAllInvigilator() {

        try {
            return mockMvc.perform(delete(INVIGILATOR_URL + "/deleteAll"))
                    .andExpect(status().isNoContent())
                    .andDo(print()).andReturn();

        } catch (Exception exception) {
            throw new AssertionError("thrown exception", exception);
        }
    }
}

