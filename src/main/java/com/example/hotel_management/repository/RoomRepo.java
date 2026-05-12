package com.example.hotel_management.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hotel_management.entity.Room;
import com.example.hotel_management.entity.RoomType;

import lombok.ToString;

public interface RoomRepo extends JpaRepository<Room, Long> {
	

		@Query("""
		    SELECT r FROM Room r
		    WHERE r.type = :roomType
		    AND r.adultOccupancy >= :adults
		    AND r.childOccupancy >= :children
		    AND r.price <= :price
		    AND r.id NOT IN (
		        SELECT b.room.id FROM Booking b
		        WHERE b.checkInDate < :checkout
		        AND b.checkOutDate > :checkin
		    )
		""")
		List<Room> findAvailableRooms(
		        @Param("checkout") LocalDate checkout,
		        @Param("checkin") LocalDate checkin,
		        @Param("price") BigDecimal price,
		        @Param("roomType") RoomType roomType,
		        @Param("adults") int adults,
		        @Param("children") int children
		);
}
