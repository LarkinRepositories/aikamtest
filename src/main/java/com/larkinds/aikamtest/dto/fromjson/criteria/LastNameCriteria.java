package com.larkinds.aikamtest.dto.fromjson.criteria;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.larkinds.aikamtest.dto.model.CustomerDto;
import com.larkinds.aikamtest.service.SearchService;
import lombok.Value;

import java.util.List;

import static java.util.Objects.requireNonNull;

@Value
public class LastNameCriteria implements Criteria {
    @JsonProperty("lastName")
    String lastName;

    @JsonCreator
    public LastNameCriteria(@JsonProperty("lastName")final String lastName) {
        this.lastName = requireNonNull(lastName);
    }

    @Override
    public List<CustomerDto> getResult(SearchService service) {
        return service.findAllByLastName(lastName);
    }
}
