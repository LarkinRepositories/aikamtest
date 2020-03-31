package com.larkinds.aikamtest.dto.fromjson.criteria;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.larkinds.aikamtest.dto.model.CustomerDto;
import com.larkinds.aikamtest.service.SearchService;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Objects.requireNonNull;

@Value
public class ExpensesCriteria implements Criteria {
    @JsonProperty("minExpenses")
    Integer minExpenses;
    @JsonProperty("maxExpenses")
    Integer maxExpenses;

    @JsonCreator
    public ExpensesCriteria(@JsonProperty("minExpenses")final Integer minExpenses, @JsonProperty("maxExpenses")final Integer maxExpenses) {
        this.minExpenses = requireNonNull(minExpenses);
        this.maxExpenses = requireNonNull(maxExpenses);
    }

    @Override
    public List<CustomerDto> getResult(SearchService service) {
        return service.findAllWithExpense(BigDecimal.valueOf(minExpenses), BigDecimal.valueOf(maxExpenses));
    }
}
