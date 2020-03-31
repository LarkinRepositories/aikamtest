package com.larkinds.aikamtest.service;

import com.larkinds.aikamtest.dto.tojson.output.StatOutPut;

import java.time.LocalDate;

public interface StatService {
    /**
     * Returns statistic by purchases made in a certain interval of time
     * @param startDate search start point
     * @param endDate search end point
     * @return statistic matching criteria
     */
    StatOutPut getStat(LocalDate startDate, LocalDate endDate) throws Exception;
}
