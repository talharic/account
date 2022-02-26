package com.talharic.accountapi.service;

import com.talharic.accountapi.dto.CustomerDto;
import com.talharic.accountapi.dto.converter.CustomerDtoConverter;
import com.talharic.accountapi.exception.CustomerNotFoundException;
import com.talharic.accountapi.model.Customer;
import com.talharic.accountapi.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    protected Customer findCustomerById(String id) {
        return customerRepository.findById(id)
                .orElseThrow(
                        () -> new CustomerNotFoundException("Customer could not find by id: " + id));

    }

    public CustomerDto getCustomerById(String customerId) {
        return converter.convertToCustomerDto(findCustomerById(customerId));
    }
}
