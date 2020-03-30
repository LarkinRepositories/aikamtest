package com.larkinds.aikamtest.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.larkinds.aikamtest.dto.fromjson.criteria.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Slf4j
public class SearchDeserializer extends JsonDeserializer<SearchDto> {

    private static final String LAST_NAME_KEY = "lastName";
    private static final String PRODUCT_NAME_KEY = "productName";
    private static final String MIN_TIMES_KEY = "minTimes";
    private static final String MIN_EXPENSES_KEY = "minExpenses";
    private static final String MAX_EXPENSES_KEY = "maxExpenses";
    private static final String BAD_CUSTOMERS_KEY = "badCustomers";

    @Override
    public SearchDto deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        SearchDto searchDto = new SearchDto();
        List<Criteria> criteriaList = new ArrayList<>();
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode criteriaNode = oc.readTree(jsonParser);
        ArrayNode node = (ArrayNode) criteriaNode.get("criterias");
        Iterator<JsonNode> criteria = node.elements();
        while(criteria.hasNext()) {
            JsonNode cNode = criteria.next();
            Criteria c;
            if (cNode.get(LAST_NAME_KEY) != null) c = mapper.readValue(cNode.toPrettyString(), LastNameCriteria.class);
            else if (cNode.get(PRODUCT_NAME_KEY) != null) c = mapper.readValue(cNode.toPrettyString(), ProductNameMinTimesCriteria.class);
            else if (cNode.get(MIN_EXPENSES_KEY) != null) c = mapper.readValue(cNode.toPrettyString(), ExpensesCriteria.class);
            else if (cNode.get(BAD_CUSTOMERS_KEY) != null) c = mapper.readValue(cNode.toPrettyString(), BadCustomersCriteria.class);
            else {
                c=null;
                log.warn(cNode.toPrettyString());
            }
            criteriaList.add(c);
        }
        searchDto.setCriteria(criteriaList);
        return searchDto;
    }
}
