package com.examination.project.infrastructure.mapper;

import com.examination.project.domain.entities.Room;
import com.examination.project.infrastructure.persistance.room.entities.RoomEntity;
import io.vavr.control.Option;
import org.mapstruct.Mapper;
import org.springframework.data.annotation.Reference;

import java.util.Collection;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    Room toRoom(RoomEntity roomEntity);

    RoomEntity toRoomEntity(Room room);

    @Reference
    default <T> T unwrapReferenceRoom(Optional<T> optional) {
        return optional.orElse(null);
    }

    @Reference
    default Optional<Room> optionToOptional(Option<Room> optionalRoom) {
        return (optionalRoom.isDefined() ? optionalRoom.toJavaOptional() : Optional.empty());
    }

    @Reference
    default Optional<RoomEntity> unwrapReferenceToOptionalRoom(Option<Room> optionalRoom) {
        return (optionalRoom.isDefined() ? optionalRoom.toJavaOptional().map(this::toRoomEntity) : Optional.empty());
    }

    Collection<Room> toRooms(Collection<RoomEntity> roomEntities);

    Collection<RoomEntity> toRoomEntities(Collection<Room> rooms);
}
