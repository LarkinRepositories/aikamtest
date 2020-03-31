package com.larkinds.aikamtest.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class BaseEntityDto {
    @JsonIgnore
    private Long id;
}
