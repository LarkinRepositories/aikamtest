package com.larkinds.aikamtest.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.larkinds.aikamtest.dto.fromjson.input.SearchDto;
import com.larkinds.aikamtest.dto.fromjson.input.StatDto;
import com.larkinds.aikamtest.dto.tojson.output.CriteriaOutputDto;
import com.larkinds.aikamtest.dto.tojson.output.MyError;
import com.larkinds.aikamtest.dto.tojson.output.OutputDto;
import com.larkinds.aikamtest.dto.tojson.output.SearchOutPut;
import com.larkinds.aikamtest.service.MainService;
import com.larkinds.aikamtest.service.SearchService;
import com.larkinds.aikamtest.service.StatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MainServiceImpl implements MainService {
    private ObjectMapper mapper;
    private SearchService searchService;
    private StatService statService;

    private final static String SEARCH_OPERATION = "search";
    private final static String STAT_OPERATION = "stat";

    @Autowired
    public MainServiceImpl(ObjectMapper mapper, SearchService searchService, StatService statService) {
        this.mapper = mapper;
        this.searchService = searchService;
        this.statService = statService;
    }

    @Override
    public OutputDto processAndWrite(String... args) throws Exception {
        final String operation = args[0].toLowerCase();
        final String inputFile = args[1];
        final String outputFile = args[2];
        OutputDto dto = null;
        try {
            if (SEARCH_OPERATION.equals(operation)) {
                SearchDto searchDto = null;
                try {
                    searchDto = mapper.readValue(new File(inputFile), SearchDto.class);
                } catch (IOException e) {
                    log.warn(e.getMessage());
                }
                List<CriteriaOutputDto> results = new ArrayList<>();
                assert searchDto != null;
                searchDto.getCriteria().forEach(e -> {
                    results.add(new CriteriaOutputDto(e, e.getResult(searchService)));
                });
                dto = new SearchOutPut(results);
                try {
                    mapper.writeValue(new File(outputFile), dto);
                } catch (IOException e) {
                    log.warn(e.getMessage());
                }
            } else if (STAT_OPERATION.equals(operation)) {
                StatDto statDto = null;
                try {
                    statDto = mapper.readValue(new File(inputFile), StatDto.class);
                } catch (IOException e) {
                    log.warn(e.getMessage());
                }
                assert statDto != null;
                dto = statService.getStat(LocalDate.parse(statDto.getStartDate()), LocalDate.parse(statDto.getEndDate()));
                try {
                    mapper.writeValue(new File(outputFile), dto);
                } catch (IOException e) {
                    log.warn(e.getMessage());
                }
            } else {
                throw new Exception("Unsupported operation");
            }
        } catch (Exception e) {
            MyError error = new MyError(e.getMessage());
            mapper.writeValue(new File(outputFile), error);
        }
        return dto;
    }
}
