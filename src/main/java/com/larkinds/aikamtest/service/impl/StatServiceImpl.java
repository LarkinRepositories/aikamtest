package com.larkinds.aikamtest.service.impl;

import com.larkinds.aikamtest.dto.model.PurchaseDto;
import com.larkinds.aikamtest.dto.tojson.output.CustomerStatDto;
import com.larkinds.aikamtest.dto.tojson.output.StatOutPut;
import com.larkinds.aikamtest.mapper.PurchaseMapper;
import com.larkinds.aikamtest.repository.PurchaseRepository;
import com.larkinds.aikamtest.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StatServiceImpl implements StatService {

    private PurchaseRepository purchaseRepository;
    private PurchaseMapper purchaseMapper;

    @Autowired
    public StatServiceImpl(PurchaseRepository purchaseRepository, PurchaseMapper purchaseMapper) {
        this.purchaseRepository = purchaseRepository;
        this.purchaseMapper = purchaseMapper;
    }

    @Override
    public StatOutPut getStat(LocalDate startDate, LocalDate endDate) {
        Integer totalDays = Period.between(startDate, endDate).getDays();
        List<PurchaseDto> purchases = purchaseMapper.toDtoList(purchaseRepository.findAllByCreatedBetween(startDate, endDate));
        Set<CustomerStatDto> customers = purchases.stream().distinct().
            map(e-> new CustomerStatDto(e.getCustomer().getLastName(), e.getCustomer().getFirstName(),
                                purchaseRepository.getProductExpensesList(e.getCustomer().getId()),
                        purchaseRepository.getCustomerTotalExpense(e.getCustomer().getId()))).collect(Collectors.toSet());
        BigDecimal totalExpenses = customers.stream().map(CustomerStatDto::getTotalExpenses).reduce(BigDecimal::add).get();
        BigDecimal avgExpenses =  totalExpenses.divide(BigDecimal.valueOf(customers.size()),2, RoundingMode.CEILING);
        return new StatOutPut(totalDays, customers,totalExpenses, avgExpenses);
    }
}
