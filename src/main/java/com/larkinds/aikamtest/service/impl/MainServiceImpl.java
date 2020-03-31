package com.larkinds.aikamtest.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.larkinds.aikamtest.dto.fromjson.input.SearchDto;
import com.larkinds.aikamtest.dto.fromjson.input.StatDto;
import com.larkinds.aikamtest.dto.tojson.output.CriteriaOutputDto;
import com.larkinds.aikamtest.dto.tojson.output.OutputDto;
import com.larkinds.aikamtest.dto.tojson.output.SearchOutPut;
import com.larkinds.aikamtest.dto.tojson.output.StatOutPut;
import com.larkinds.aikamtest.service.MainService;
import com.larkinds.aikamtest.service.SearchService;
import com.larkinds.aikamtest.service.StatService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
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

    @SneakyThrows
    @Override
    public OutputDto processAndWrite(String... args) {
        String operation = args[0].toLowerCase();
        if (SEARCH_OPERATION.equals(operation)) {
            SearchDto searchDto = mapper.readValue(new File(args[1]), SearchDto.class);
            List<CriteriaOutputDto> results = new ArrayList<>();
            searchDto.getCriteria().forEach(e->{
                results.add(new CriteriaOutputDto(e, e.getResult(searchService)));
            });
            SearchOutPut searchOutPut = new SearchOutPut(results);
            mapper.writeValue(new File(args[2]), searchOutPut);
            return searchOutPut;
        } else if (STAT_OPERATION.equals(operation)) {
            StatDto statDto = mapper.readValue(new File(args[1]), StatDto.class);
            StatOutPut stat = statService.getStat(LocalDate.parse(statDto.getStartDate()), LocalDate.parse(statDto.getEndDate()));
            mapper.writeValue(new File(args[2]), stat);
            return stat;
        }
        return null;
    }
}
