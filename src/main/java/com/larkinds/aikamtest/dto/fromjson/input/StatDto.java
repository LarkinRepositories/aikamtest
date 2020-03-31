package com.larkinds.aikamtest.dto.fromjson.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class StatDto extends InputDto {
    @JsonProperty("startDate")
    String startDate;
    @JsonProperty("endDate")
    String endDate;

    @JsonCreator
    public StatDto(@JsonProperty("startDate")final String startDate, @JsonProperty("endDate")final String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
