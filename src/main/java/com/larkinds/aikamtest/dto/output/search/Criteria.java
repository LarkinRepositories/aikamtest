package com.larkinds.aikamtest.dto.output.search;

import com.larkinds.aikamtest.dto.model.CustomerDto;
import com.larkinds.aikamtest.service.SearchService;

import java.util.List;

public interface Criteria {
    List<CustomerDto> getResult(SearchService service);
}
