package com.larkinds.aikamtest.dto.fromjson.criteria;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.larkinds.aikamtest.dto.model.CustomerDto;
import com.larkinds.aikamtest.service.SearchService;

import java.util.List;

public interface Criteria {
    List<CustomerDto> getResult(SearchService service);
}
