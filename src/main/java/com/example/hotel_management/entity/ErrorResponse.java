package com.example.hotel_management.entity;

import lombok.Data;

@Data
public class ErrorResponse {
	
	String errorMessage;	

	public ErrorResponse(String message) {
		// TODO Auto-generated constructor stub
		this.errorMessage = message;
	}

}
