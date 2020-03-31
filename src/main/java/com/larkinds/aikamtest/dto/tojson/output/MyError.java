package com.larkinds.aikamtest.dto.tojson.output;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

@Value
@JsonPropertyOrder({"type", "message"})
public class MyError extends OutputDto {
    @JsonProperty("message")
    String message;

    @JsonCreator
    public MyError(@JsonProperty("message")String message) {
        super("error");
        this.message = message;
    }
}
