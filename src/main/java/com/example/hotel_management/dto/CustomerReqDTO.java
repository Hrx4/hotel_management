package com.example.hotel_management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class CustomerReqDTO {
			@NotBlank
			private String customerName;
			@NotBlank
			@Size(min = 3 , message = "Username should be minimum 3 characters")
		    private String userName;
			@NotBlank
		    private String password;
			@NotBlank
		    private String confirmPassword;
		    @Email
		    private String email;
		    @NotBlank
		    @Size(min=8 , max=10 , message = "Enter a valid mobile number")
			private String phoneNumber;
		    @NotBlank
		    private String address;
}
