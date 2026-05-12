package com.example.hotel_management.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerLoginDTO {
	@NotBlank
	public String userName;
	@NotBlank
	public String password;
}
