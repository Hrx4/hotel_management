package com.example.hotel_management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.hotel_management.entity.ErrorResponse;
import com.example.hotel_management.exception.CustomerNotFoundExceptions;
import com.example.hotel_management.exception.RoomNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(CustomerNotFoundExceptions.class)
	public ResponseEntity<?> handleCustomerException(CustomerNotFoundExceptions exception){
		ErrorResponse erroeResponse = new ErrorResponse(exception.getMessage());
		return new ResponseEntity<>(erroeResponse , HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleRuntimeException(RuntimeException exception){
		ErrorResponse errorResponse = new ErrorResponse(exception.getMessage() );
		return new ResponseEntity<>(errorResponse , HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(RoomNotFoundException.class)
	public ResponseEntity<?> handleRoomException(RoomNotFoundException exception){
		ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
		return new ResponseEntity<>(errorResponse , HttpStatus.NOT_FOUND);
	}
}
