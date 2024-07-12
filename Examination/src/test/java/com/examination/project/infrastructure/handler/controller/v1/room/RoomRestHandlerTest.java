package com.examination.project.infrastructure.handler.controller.v1.room;

import com.examination.project.domain.fixture.RoomFixture;
import com.examination.project.infrastructure.handler.controller.IntegrationTest;
import lombok.val;
import org.junit.jupiter.api.Test;

import static io.vavr.control.Either.right;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RoomRestHandlerTest extends IntegrationTest {

    @Test
    void should_add_new_room() {

        //given
        val room = RoomFixture.one();

        //when
        when(this.roomUseCaseMocked.createRoom(room)).thenReturn(right(room));

        val expectedResponse = this.roomRestHandlerFixture.createRoom().with(mockMvc, objectMapper);

        //then
        verify(roomUseCaseMocked, atLeastOnce()).createRoom(room);
        assertEquals(expectedResponse, isNotNull());

    }

    @Test
    void should_return_fetch_all_rooms() {

        //given
        val rooms = RoomFixture.from(10);

        //when
        when(this.roomUseCaseMocked.getAllRooms()).thenReturn(right(rooms.asJava()));

        val expectedResponse = this.roomRestHandlerFixture.getAllRooms().with(mockMvc, objectMapper);

        //then
        verify(roomUseCaseMocked, atLeastOnce()).getAllRooms();
        assertEquals(rooms, expectedResponse);

    }

    @Test
    void should_delete_invigilator_byId() {


    }


    @Test
    void should_delete_all_invigilators() {


    }

}
