package com.examination.project.persistance.mapper;

import com.examination.project.persistance.entities.RoomEntity;
import com.examination.project.domain.Room;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    Room toRoom(RoomEntity roomEntity);

    RoomEntity toRoomEntity(Room room);

    Collection<Room> toRooms(Collection<RoomEntity> roomEntities);

    Collection<RoomEntity> toRoomEntities(Collection<Room> rooms);
}
