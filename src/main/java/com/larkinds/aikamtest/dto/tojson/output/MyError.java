package com.larkinds.aikamtest.dto.tojson.output;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class MyError extends OutputDto {
    @JsonProperty("message")
    String message;

    @JsonCreator
    public MyError(@JsonProperty("message")String message) {
        super("error");
        this.message = message;
    }
}
