package com.larkinds.aikamtest.dto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerDto extends BaseEntityDto {
    @JsonProperty("lastName")
    String lastName;
    @JsonProperty("firstName")
    String firstName;


}
