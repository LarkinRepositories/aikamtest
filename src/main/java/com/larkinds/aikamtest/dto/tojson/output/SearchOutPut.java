package com.larkinds.aikamtest.dto.tojson.output;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.larkinds.aikamtest.dto.fromjson.criteria.Criteria;
import com.larkinds.aikamtest.dto.model.CustomerDto;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.List;
import java.util.Map;

import static java.util.Objects.requireNonNull;
@JsonPropertyOrder({"type", "results"})
@Value
public class SearchOutPut extends OutputDto {
   @JsonProperty("results")
   List<CriteriaOutputDto> results;

    @JsonCreator
    public SearchOutPut(@JsonProperty("results")final List<CriteriaOutputDto> results) {
        super("search");
        this.results = requireNonNull(results);
    }
}
