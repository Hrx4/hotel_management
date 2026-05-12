package com.example.hotel_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel_management.dto.CustomerLoginDTO;
import com.example.hotel_management.dto.CustomerReqDTO;
import com.example.hotel_management.dto.CustomerResDTO;
import com.example.hotel_management.entity.Customer;
import com.example.hotel_management.exception.CustomerNotFoundExceptions;
//import com.example.hotel_management.HotelManagementApplication.CustomerMapper;
import com.example.hotel_management.mapper.CustomerMapper;
import com.example.hotel_management.repository.CustomerRepo;


@Service
public class CustomerService {
	@Autowired
    private CustomerRepo customerRepo;
	
	@Autowired
    private CustomerMapper customerMapper;

    public CustomerResDTO addCustomer(CustomerReqDTO reqDTO) {

        if (!reqDTO.getPassword().equals(reqDTO.getConfirmPassword())) {
            throw new RuntimeException("Passwords do not match");
        }

        Customer customer = customerMapper.toEntity(reqDTO);
        Customer savedCustomer = customerRepo.save(customer);
        return customerMapper.toResponseDto(savedCustomer);
    }

    public CustomerResDTO getCustomer(Long id) {
        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new CustomerNotFoundExceptions(
                        "Customer not found with this id : " + id));

        return customerMapper.toResponseDto(customer);
    }

    public List<CustomerResDTO> getCustomers() {
        List<Customer> customers = customerRepo.findAll();
        return customerMapper.toCustomerResDTOs(customers);
    }

    public CustomerResDTO loginCustomer(CustomerLoginDTO customerLoginDTO) {
    	Customer customer = customerRepo.findByUserName(customerLoginDTO.getUserName())
    			.orElseThrow(()->new CustomerNotFoundExceptions("No customer found with this username"));
    	if(!customerLoginDTO.getPassword().equals(customer.getPassword())) {
    		throw new CustomerNotFoundExceptions("Password is not matching");
    	}
    	return customerMapper.toResponseDto(customer);
    }


//    public BookingResDTO

}