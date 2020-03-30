package com.larkinds.aikamtest.mapper.entity;

import com.larkinds.aikamtest.dto.model.CustomerDto;
import com.larkinds.aikamtest.model.Customer;
import com.larkinds.aikamtest.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper extends AbstractMapper<Customer, CustomerDto> {
    private ModelMapper mapper;
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerMapper(ModelMapper mapper, CustomerRepository customerRepository) {
        super(Customer.class, CustomerDto.class);
        this.mapper = mapper;
        this.customerRepository = customerRepository;
    }

}
