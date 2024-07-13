package com.examination.project.infrastructure.handler.controller.v1.room;

import com.examination.project.domain.entities.Room;
import com.examination.project.domain.fixture.RoomFixture;
import com.examination.project.infrastructure.handler.controller.IntegrationTest;
import com.examination.project.infrastructure.handler.utils.EitherTools;
import io.vavr.control.Either;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static com.examination.project.infrastructure.handler.utils.EitherTools.nothing;
import static com.examination.project.infrastructure.handler.utils.ModelFactory.defaultRoom;
import static io.vavr.control.Either.right;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RoomRestHandlerTest extends IntegrationTest {

    @Test
    void should_add_new_room() {

        //when
        when(this.roomUseCaseMocked.createRoom(any(Room.class))).thenReturn(right(defaultRoom()));

        val expected = this.roomRestHandlerFixture.createRoom();

        //then
        verify(roomUseCaseMocked, atLeastOnce()).createRoom(defaultRoom());
        assertEquals(expected.getResponse().getStatus(), HttpStatus.CREATED.value());
    }

    @Test
    void should_update_room_number() {


    }


    @Test
    void should_add_several_rooms() {


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
    void should_delete_all_rooms() {

        //when
        when(this.roomUseCaseMocked.deleteAllRooms()).thenReturn(nothing());

        val resultActions = this.roomRestHandlerFixture.deleteAllRooms();

        //then
        verify(roomUseCaseMocked, atMostOnce()).deleteAllRooms();
        assertEquals(resultActions.getResponse().getStatus(), HttpStatus.NO_CONTENT.value());
    }
}
