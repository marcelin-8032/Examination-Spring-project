package com.examination.project.infrastructure.handler.controller.v1.room.fixture;

import com.examination.project.domain.entities.Room;
import com.examination.project.domain.fixture.RoomFixture;
import com.examination.project.infrastructure.handler.utils.MockMvcUtils;
import com.examination.project.infrastructure.handler.utils.MvcBinder;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.collection.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RoomRestHandlerFixture extends MockMvcUtils {

    private static final String ROOM_URL = "/v1/" + "rooms";

    protected RoomRestHandlerFixture(MockMvc mockMvc, ObjectMapper objectMapper) {
        super(mockMvc, objectMapper);
    }

    public static RoomRestHandlerFixture from(MockMvc mockMvc, ObjectMapper objectMapper) {
        return new RoomRestHandlerFixture(mockMvc, objectMapper);
    }

    public MvcBinder<ResponseEntity<Void>> createRoom() {

        var room = RoomFixture.one();

        return (mvc, objectMapper) -> {

            try {
                final ResultActions resultActions = mockMvc.perform(post(ROOM_URL + "/create")
                                .contentType(APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(room)))
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
//
//    public MvcBinder<ResponseEntity<Void>> deleteInvigilatorById() {
//
//        return (mvc, objectMapper) -> {
//            try {
//                mockMvc.perform(delete(INVIGILATOR_URL + "1"))
//                        .andExpect(status().isOk())
//                        .andDo(print());
//        /*    val result = resultActions.andReturn();
//            val contentAsString = result.getResponse().getContentAsString();
//            objectMapper.readValue(contentAsString, Invigilator.class);*/
//                return new ResponseEntity<>(HttpStatus.OK);
//            } catch (Exception exception) {
//                throw new AssertionError("thrown exception", exception);
//
//            }
//        };
//    }
//
//
//    public MvcBinder<ResponseEntity<Void>> deleteAllInvigilator() {
//
//        return (mvc, objectMapper) -> {
//            try {
//                mockMvc.perform(delete(INVIGILATOR_URL + "/deleteAll"))
//                        .andExpect(status().isOk())
//                        .andDo(print());
//
//        /*    val result = resultActions.andReturn();
//            val contentAsString = result.getResponse().getContentAsString();
//            objectMapper.readValue(contentAsString, Invigilator.class);*/
//                return new ResponseEntity<>(HttpStatus.OK);
//            } catch (Exception exception) {
//                throw new AssertionError("thrown exception", exception);
//            }
//        };
//    }


}

