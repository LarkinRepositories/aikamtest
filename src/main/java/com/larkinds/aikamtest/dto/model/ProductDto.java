package com.larkinds.aikamtest.dto.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductDto extends BaseEntityDto {
    private String name;
    private BigDecimal price;
}
