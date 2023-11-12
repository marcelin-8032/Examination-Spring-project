package com.examination.project.infrastructure.persistance.room.repository;

import com.examination.project.infrastructure.persistance.room.entities.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<RoomEntity, Integer>,
        JpaRepository<RoomEntity, Integer> {
}
