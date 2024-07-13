package com.examination.project.infrastructure.handler.controller.v1.room.fixture;

import com.examination.project.domain.entities.Room;
import com.examination.project.infrastructure.handler.utils.MockMvcUtils;
import com.examination.project.infrastructure.handler.utils.MvcBinder;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.collection.List;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static com.examination.project.infrastructure.handler.utils.ModelFactory.defaultRoom;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RoomRestHandlerFixture extends MockMvcUtils {

    private static final String ROOM_URL = "/v1/" + "rooms";

    protected RoomRestHandlerFixture(MockMvc mockMvc, ObjectMapper objectMapper) {
        super(mockMvc, objectMapper);
    }

    public static RoomRestHandlerFixture from(MockMvc mockMvc, ObjectMapper objectMapper) {
        return new RoomRestHandlerFixture(mockMvc, objectMapper);
    }

    public MvcResult createRoom() {

        try {
            return mockMvc.perform(post(ROOM_URL + "/create")
                            .contentType(APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(defaultRoom())))
                    .andExpect(status().isCreated()).andReturn();

        } catch (Exception exception) {
            throw new AssertionError("thrown exception", exception);
        }
    }

    public MvcBinder<List<Room>> getAllRooms() {

        return (mvc, objectMapper) -> {
            try {
                final ResultActions resultActions = mockMvc.perform(get(ROOM_URL)
                        .accept(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk());

                final MvcResult result = resultActions.andReturn();
                final String contentAsString = result.getResponse().getContentAsString();

                return objectMapper.readValue(contentAsString, new TypeReference<List<Room>>() {
                });

            } catch (Exception e) {
                throw new AssertionError("should not have thrown any exception", e);
            }
        };

    }

    public MvcResult deleteAllRooms() {

        try {
            return mockMvc.perform(delete(ROOM_URL + "/deleteAll"))
                    .andDo(print())
                    .andReturn();

        } catch (Exception exception) {
            throw new AssertionError("thrown exception", exception);

        }
    }
}

