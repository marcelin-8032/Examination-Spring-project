package com.cegefos.tp1.mapper;

import com.cegefos.tp1.domains.Room;
import com.cegefos.tp1.persistance.entities.RoomEntity;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface SalleMapper {
    Room toSalleDto(RoomEntity roomEntity);

    RoomEntity toSalle(Room room);

    Collection<Room> toSalleDtos(Collection<RoomEntity> roomEntity);

    Collection<RoomEntity> toSalles(Collection<Room> rooms);
}
