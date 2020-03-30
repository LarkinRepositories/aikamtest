package com.larkinds.aikamtest.dto.output.search;

import com.larkinds.aikamtest.dto.model.CustomerDto;
import com.larkinds.aikamtest.service.SearchService;
import lombok.Data;

import java.util.List;

@Data
public class LastNameCriteriaDto implements Criteria {
    private String lastName;

    @Override
    public List<CustomerDto> getResult(SearchService service) {
       return service.findAllByLastName(lastName);
    }
}
