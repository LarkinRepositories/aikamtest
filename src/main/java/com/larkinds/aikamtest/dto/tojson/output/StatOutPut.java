package com.larkinds.aikamtest.dto.tojson.output;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Value
@JsonPropertyOrder({"type", "totalDays", "customers", "totalExpenses", "avgExpenses"})
public class StatOutPut extends OutputDto {
    @JsonProperty("totalDays")
    Integer totalDays;
    @JsonProperty("customers")
    Set<CustomerStatDto> customers;
    @JsonProperty("totalExpenses")
    BigDecimal totalExpenses;
    @JsonProperty("avgExpenses")
    BigDecimal avgExpenses;

    public StatOutPut(final Integer totalDays, final Set<CustomerStatDto> customers, final BigDecimal totalExpenses, final BigDecimal avgExpenses) {
        super("stat");
        this.totalDays = totalDays;
        this.customers = customers;
        this.totalExpenses = totalExpenses;
        this.avgExpenses = avgExpenses;
    }
}
