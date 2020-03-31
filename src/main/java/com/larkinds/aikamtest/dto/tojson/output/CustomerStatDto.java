package com.larkinds.aikamtest.dto.tojson.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

@Value
public class CustomerStatDto {
    @JsonProperty("name")
    String customerName;
    @JsonProperty("purchases")
    List<ProductExpensesDto> purchases;
    @JsonProperty("totalExpenses")
    BigDecimal totalExpenses;

    public CustomerStatDto(final String lastName, final String firstName,
                           final List<ProductExpensesDto> purchases, final BigDecimal totalExpenses) {
        this.customerName = lastName.concat(" ").concat(firstName);
        this.purchases = purchases;
        this.totalExpenses = totalExpenses;
    }
}
