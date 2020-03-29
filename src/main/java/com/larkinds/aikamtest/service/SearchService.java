package com.larkinds.aikamtest.service;

import com.larkinds.aikamtest.dto.model.CustomerDto;

import java.math.BigDecimal;
import java.util.List;


public interface SearchService {
    /**
     * Returns list of CustomerDto with a specific last name
     * @param lastName last name to search
     * @return list of CustomerDto matched @param criteria
     */
    List<CustomerDto> findAllByLastName(String lastName);

    /**
     * Retuns list of CustomerDto which bought productName certain amount of times (puchaseCount)
     * @param productName name of the product
     * @param purchaseCount amount of times product'd been bought
     * @return list of CustomerDto matched @param criteria
     */
    List<CustomerDto> findByProductNameAndPurchaseCount(String productName, long purchaseCount);

    /**
     * Returns list of CustomerDto which total amount of money spent on products in a certain interval
     * @param minValue inimum amount of money spent
     * @param maxValue maximum amount of money spent
     * @return list of CustomerDto matched @param criteria
     */
    List<CustomerDto> findAllWithExpense(BigDecimal minValue, BigDecimal maxValue);

    /**
     * Returns list of CustomerDto wich bought the least amount of products with list size limited to @param limit
     * @param limit amount of customers
     * @return list of CustomerDto matched @param criteria
     */
    List<CustomerDto> findBadCustomers(Integer limit);

}
