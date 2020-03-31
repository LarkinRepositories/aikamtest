package com.larkinds.aikamtest.dto.fromjson.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.larkinds.aikamtest.deserializer.SearchDeserializer;
import com.larkinds.aikamtest.dto.fromjson.criteria.Criteria;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

import static java.util.Objects.requireNonNull;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@JsonDeserialize(using = SearchDeserializer.class)
public class SearchDto extends InputDto{
    List<Criteria> criteria;

    @JsonCreator
    public SearchDto(@JsonProperty("criterias")final List<Criteria> criteria) {
        this.criteria = requireNonNull(criteria);
    }
}
