package com.examination.project.infrastructure.persistance.room;

import com.examination.project.infrastructure.persistance.RepositoryBaseTest;
import com.examination.project.infrastructure.persistance.room.entities.RoomEntity;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;

import static org.assertj.core.api.Assertions.assertThat;


class RoomRepositoryTest extends RepositoryBaseTest {

    @Test
    void should_find_all_rooms() {
        val roomEntity = RoomEntity
                .builder()
                .number(100)
                .build();

        this.entityManager.persist(roomEntity);

        val optionalRoomEntity = this.roomRepository.findOne(Example.of(roomEntity));

        assertThat(optionalRoomEntity).isNotEmpty().contains(roomEntity);
    }
}