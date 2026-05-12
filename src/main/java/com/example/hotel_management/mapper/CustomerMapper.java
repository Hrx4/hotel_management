package com.example.hotel_management.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.hotel_management.dto.CustomerReqDTO;
import com.example.hotel_management.dto.CustomerResDTO;
import com.example.hotel_management.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "bookings", ignore = true)
    Customer toEntity(CustomerReqDTO reqDto);
    CustomerResDTO toResponseDto(Customer customer);
    List<CustomerResDTO> toCustomerResDTOs(List<Customer> customers);
}
