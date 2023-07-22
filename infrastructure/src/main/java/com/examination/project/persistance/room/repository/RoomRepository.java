package com.examination.project.persistance.room.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.examination.project.persistance.room.entities.RoomEntity;

@Repository
public interface RoomRepository extends CrudRepository<RoomEntity, Integer> {

}
