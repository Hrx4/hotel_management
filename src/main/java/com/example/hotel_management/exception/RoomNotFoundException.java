package com.example.hotel_management.exception;

public class RoomNotFoundException extends RuntimeException {
	public RoomNotFoundException(String message) {
		super(message);
	}
}
