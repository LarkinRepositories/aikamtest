package com.larkinds.aikamtest.dto.fromjson.criteria;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.larkinds.aikamtest.deserializer.SearchDeserializer;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

import static java.util.Objects.requireNonNull;

@Data
@NoArgsConstructor
@JsonDeserialize(using = SearchDeserializer.class)
public class SearchDto {
    List<Criteria> criteria;

    @JsonCreator
    public SearchDto(@JsonProperty("criterias")final List<Criteria> criteria) {
        this.criteria = requireNonNull(criteria);
    }
}
