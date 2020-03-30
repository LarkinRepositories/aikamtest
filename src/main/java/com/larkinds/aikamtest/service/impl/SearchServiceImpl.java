package com.larkinds.aikamtest.service.impl;

import com.larkinds.aikamtest.dto.model.CustomerDto;
import com.larkinds.aikamtest.mapper.entity.CustomerMapper;
import com.larkinds.aikamtest.repository.CustomerRepository;
import com.larkinds.aikamtest.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;


@Service
@Transactional
public class SearchServiceImpl implements SearchService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    @Autowired
    public SearchServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDto> findAllByLastName(String lastName) {
        return customerMapper.toDtoList(customerRepository.findAllByLastName(lastName));
    }

    @Override
    public List<CustomerDto> findByProductNameAndPurchaseCount(String productName, long purchaseCount) {
        return customerMapper.toDtoList(
                customerRepository.findByProductNameAndPurchaseCount(productName, purchaseCount));
    }

    @Override
    public List<CustomerDto> findAllWithExpense(BigDecimal minValue, BigDecimal maxValue) {
        return customerMapper.toDtoList(customerRepository.findAllWithExpense(minValue, maxValue));
    }

    @Override
    public List<CustomerDto> findBadCustomers(Integer limit) {
        return customerMapper.toDtoList(customerRepository.findBadCustomers(PageRequest.of(0, limit)).toList());
    }

}
