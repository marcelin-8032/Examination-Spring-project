package com.examination.project.domain.usecases.room;

import com.examination.project.domain.usecases.UseCaseIntegrationTest;
import lombok.val;
import org.junit.jupiter.api.Test;


import static com.examination.project.utils.ModelFactory.*;
import static io.vavr.control.Either.right;
import static org.junit.jupiter.api.Assertions.*;

class RoomUseCaseTest extends UseCaseIntegrationTest {

    @Test
    void should_create_room() {

        //when
        val result = this.roomUseCase.createRoom(defaultRoom());

        //then
        assertNotNull(result.get());
        assertEquals(result, right(defaultRoom()));
        assertEquals(result.get().department(), "main");
    }

    @Test
    void should_create_several_rooms() {

        //when
        val result = this.roomUseCase.createSeveralRooms(defaultRooms().asJava());

        //then
        assertTrue(result.isRight());
    }

    @Test
    void should_update_room() throws Exception {

        val result = this.roomUseCase.updateRoom(1, 148966);

        assertTrue(result.isRight());
    }

    @Test
    void should_get_all_rooms() {

        val result = this.roomUseCase.getAllRooms();

        assertTrue(result.isRight());
        assertEquals(result.get().size(), 3);
        assertTrue(result.get().stream().allMatch(room -> room.floor() == 3));
    }


    @Test
    void should_delete_all_rooms() {

        val result = this.roomUseCase.deleteAllRooms();

        assertTrue(result.isRight());
    }
}
