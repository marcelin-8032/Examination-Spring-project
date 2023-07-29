package com.examination.project.mapper;

import com.examination.project.entities.Room;
import com.examination.project.handler.persistance.room.entities.RoomEntity;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    Room toRoom(RoomEntity roomEntity);

    RoomEntity toRoomEntity(Room room);

    Collection<Room> toRooms(Collection<RoomEntity> roomEntities);

    Collection<RoomEntity> toRoomEntities(Collection<Room> rooms);
}
