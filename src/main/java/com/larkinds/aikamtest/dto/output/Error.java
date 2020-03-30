package com.larkinds.aikamtest.dto.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Error {
    @JsonProperty("message")
    String message;
}
