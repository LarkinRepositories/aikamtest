package com.larkinds.aikamtest.dto.input;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;

import java.util.Map;

@Data
public class InputDto {
    @JsonAnySetter
    private Map<String, Object> criteriaMap;
}
