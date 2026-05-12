package com.example.hotel_management.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel_management.dto.CustomerLoginDTO;
import com.example.hotel_management.dto.CustomerReqDTO;
import com.example.hotel_management.dto.CustomerResDTO;
import com.example.hotel_management.service.CustomerService;


@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	public CustomerService customerService;
	
    @PostMapping("/add")
    public ResponseEntity<CustomerResDTO> addCustomer(@Valid @RequestBody CustomerReqDTO customerDto) {
    	CustomerResDTO createdCustomer = customerService.addCustomer(customerDto);
    	return new ResponseEntity<>(createdCustomer , HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<CustomerResDTO>> getCustomers(){
    	List<CustomerResDTO> customers = customerService.getCustomers();
    	return new ResponseEntity<>(customers , HttpStatus.FOUND);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResDTO> getCustomer(@PathVariable Long id){
    	CustomerResDTO customer = customerService.getCustomer(id);
    	return new ResponseEntity<>(customer , HttpStatus.FOUND);
    }
    @PostMapping("/login")
    public ResponseEntity<CustomerResDTO> loginCustomer(@RequestBody CustomerLoginDTO customerLoginDto) {
    	CustomerResDTO loggedinCustomer = customerService.loginCustomer(customerLoginDto);
    	return new ResponseEntity<>(loggedinCustomer , HttpStatus.CREATED);
    }
}

