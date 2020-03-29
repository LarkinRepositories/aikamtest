package com.larkinds.aikamtest.dto.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class PurchaseDto extends BaseEntityDto {
    private LocalDateTime created;
    private ProductDto product;
    private CustomerDto customer;
}
