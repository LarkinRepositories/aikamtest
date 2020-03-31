package com.larkinds.aikamtest.dto.tojson.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class ProductExpensesDto {
    @JsonProperty("name")
    String name;
    @JsonProperty("expenses")
    BigDecimal expenses;
}
