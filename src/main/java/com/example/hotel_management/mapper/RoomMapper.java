package com.example.hotel_management.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.hotel_management.dto.RoomReqDTO;
import com.example.hotel_management.dto.RoomResDTO;
import com.example.hotel_management.entity.Room;

@Mapper(componentModel = "spring")
public interface RoomMapper {
	List<RoomResDTO> toRoomResDTOs(List<Room> rooms);
    @Mapping(target = "bookings", ignore = true)
    @Mapping(target = "id" , ignore = true)
	Room toEntity(RoomReqDTO roomReqDTO);
	RoomResDTO toRoomResDTO (Room room);
	
}
