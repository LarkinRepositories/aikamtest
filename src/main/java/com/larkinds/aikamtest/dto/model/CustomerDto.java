package com.larkinds.aikamtest.dto.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerDto extends BaseEntityDto {
    private String firstName;
    private String lastName;
}
