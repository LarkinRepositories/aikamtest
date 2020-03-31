package com.larkinds.aikamtest.dto.fromjson.criteria;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.larkinds.aikamtest.dto.model.CustomerDto;
import com.larkinds.aikamtest.service.SearchService;
import lombok.Value;

import java.util.List;

import static java.util.Objects.requireNonNull;

@Value
public class BadCustomersCriteria implements Criteria {
    @JsonProperty("badCustomers")
    Integer limit;

    @JsonCreator
    public BadCustomersCriteria(@JsonProperty("badCustomers")final Integer limit) {
        this.limit = requireNonNull(limit);
    }

    @Override
    public List<CustomerDto> getResult(SearchService service) {
        return service.findBadCustomers(limit);
    }
}
