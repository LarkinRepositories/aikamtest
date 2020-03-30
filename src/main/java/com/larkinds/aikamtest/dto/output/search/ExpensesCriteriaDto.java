package com.larkinds.aikamtest.dto.output.search;

import com.larkinds.aikamtest.dto.model.CustomerDto;
import com.larkinds.aikamtest.service.SearchService;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ExpensesCriteriaDto implements Criteria {
    private BigDecimal minExpenses;
    private BigDecimal maxExpenses;

    @Override
    public List<CustomerDto> getResult(SearchService service) {
        return service.findAllWithExpense(minExpenses, maxExpenses);
    }
}
