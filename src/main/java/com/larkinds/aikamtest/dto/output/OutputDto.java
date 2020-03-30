package com.larkinds.aikamtest.dto.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.larkinds.aikamtest.dto.model.CustomerDto;
import com.larkinds.aikamtest.dto.output.search.Criteria;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class OutputDto {
    @JsonProperty("type")
    private final String type;
    @JsonProperty("results")
    Map<Criteria, List<CustomerDto>> results;
}
