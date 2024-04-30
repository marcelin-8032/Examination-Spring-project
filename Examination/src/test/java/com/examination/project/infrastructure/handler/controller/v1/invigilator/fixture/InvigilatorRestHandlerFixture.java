package com.examination.project.infrastructure.handler.controller.v1.invigilator.fixture;

import com.examination.project.domain.entities.Invigilator;
import com.examination.project.domain.fixture.InvigilatorFixture;
import com.examination.project.infrastructure.handler.utils.MockMvcUtils;
import com.examination.project.utils.MvcBinder;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.collection.List;
import lombok.val;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class InvigilatorRestHandlerFixture extends MockMvcUtils {

    private static final String INVIGILATOR_URL = "/v1/" + "invigilators";

    protected InvigilatorRestHandlerFixture(MockMvc mockMvc, ObjectMapper objectMapper) {
        super(mockMvc, objectMapper);
    }

    public static InvigilatorRestHandlerFixture from(MockMvc mockMvc, ObjectMapper objectMapper) {
        return new InvigilatorRestHandlerFixture(mockMvc, objectMapper);
    }

    public static MvcBinder<Invigilator> createInvigilator() {

        var invigilator = InvigilatorFixture.one();

        return (mockMvc, objectMapper) -> {

            try {
                final ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                                .post(INVIGILATOR_URL + "/create")
                                .contentType(APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(invigilator)))
                        .andExpect(status().isCreated());

                final MvcResult result = resultActions.andReturn();
                final String contentAsString = result.getResponse().getContentAsString();

                return objectMapper.readValue(contentAsString, Invigilator.class);

            } catch (Exception exception) {
                throw new AssertionError("thrown exception", exception);
            }
        };

    }

    public List<Invigilator> getAllInvigilators() {

        try {
            val resultActions = mockMvc.perform(MockMvcRequestBuilders
                    .get(INVIGILATOR_URL)
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
