package com.example.hotel_management.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.hotel_management.HotelManagementApplication.RoomMapper;
import com.example.hotel_management.dto.RoomReqDTO;
import com.example.hotel_management.dto.RoomResDTO;
import com.example.hotel_management.entity.Room;
import com.example.hotel_management.entity.RoomType;
import com.example.hotel_management.exception.RoomNotFoundException;
import com.example.hotel_management.mapper.RoomMapper;
import com.example.hotel_management.repository.RoomRepo;

@Service
public class RoomService {
	
	@Autowired
	private RoomRepo roomRepo;
	
	@Autowired 
	private RoomMapper roomMapper;
	
	public RoomResDTO addRoom(RoomReqDTO roomReqDTO) {
		Room room = roomMapper.toEntity(roomReqDTO);
		System.out.println(room);
		Room savedRoom = roomRepo.save(room);
		System.out.println(savedRoom);
		return roomMapper.toRoomResDTO(savedRoom);
		
	}

	public List<RoomResDTO> getRooms (){
		List<Room> rooms = roomRepo.findAll();
		return roomMapper.toRoomResDTOs(rooms);
	}
	
	public List<RoomResDTO> getAvailableRooms(LocalDate checkoutdate,
			LocalDate checkindate,
			BigDecimal price,
			RoomType roomtype,
			int adultoccupancy ,
			int childOccupancy){
		List<Room>rooms = roomRepo.findAvailableRooms(checkoutdate, checkindate, price,
				roomtype, adultoccupancy, childOccupancy);
		
		
		return roomMapper.toRoomResDTOs(rooms);
	}
	
	public RoomResDTO getRoom(Long id) {
		Room room = roomRepo.findById(id).orElseThrow(() -> new RoomNotFoundException("Room not found for the id"+id));
		return roomMapper.toRoomResDTO(room);
	}
	
}
