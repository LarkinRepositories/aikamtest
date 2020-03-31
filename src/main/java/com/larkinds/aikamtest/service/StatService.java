package com.larkinds.aikamtest.service;

import com.larkinds.aikamtest.dto.tojson.output.StatOutPut;

import java.time.LocalDate;

public interface StatService {
    /**
     *
     * @param startDate
     * @param endDate
     * @return
     */
    StatOutPut getStat(LocalDate startDate, LocalDate endDate);
}
