package com.larkinds.aikamtest.dto.output.search;

import com.larkinds.aikamtest.dto.model.CustomerDto;
import com.larkinds.aikamtest.service.SearchService;
import lombok.Data;

import java.util.List;

@Data
public class ProductNameMinTimesCriteriaDto implements Criteria {
    private String productName;
    private Integer minTimes;

    @Override
    public List<CustomerDto> getResult(SearchService service) {
        return service.findByProductNameAndPurchaseCount(productName, minTimes);
    }
}
