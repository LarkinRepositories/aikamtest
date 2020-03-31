package com.larkinds.aikamtest.dto.tojson.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.larkinds.aikamtest.dto.fromjson.criteria.Criteria;
import com.larkinds.aikamtest.dto.model.CustomerDto;
import lombok.Value;

import java.util.List;

@Value
public class CriteriaOutputDto {
    @JsonProperty("criteria")
    Criteria criteria;
    @JsonProperty("results")
    List<CustomerDto> results;
}
