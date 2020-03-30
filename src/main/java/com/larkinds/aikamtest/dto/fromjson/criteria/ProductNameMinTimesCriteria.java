package com.larkinds.aikamtest.dto.fromjson.criteria;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.larkinds.aikamtest.dto.model.CustomerDto;
import com.larkinds.aikamtest.service.SearchService;
import lombok.Value;

import java.util.List;

import static java.util.Objects.requireNonNull;

@Value
public class ProductNameMinTimesCriteria implements Criteria {
    @JsonTypeId
    String productName;
    Integer minTimes;

    @JsonCreator
    public ProductNameMinTimesCriteria(@JsonProperty("productName")final String productName, @JsonProperty("minTimes")final Integer minTimes) {
        this.productName = requireNonNull(productName);
        this.minTimes = requireNonNull(minTimes);
    }

    @Override
    public List<CustomerDto> getResult(SearchService service) {
        return service.findByProductNameAndPurchaseCount(productName, Long.valueOf(minTimes) );
    }
}
