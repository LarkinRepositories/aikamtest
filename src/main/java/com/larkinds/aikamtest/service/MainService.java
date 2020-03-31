package com.larkinds.aikamtest.service;
import com.larkinds.aikamtest.dto.tojson.output.OutputDto;

public interface MainService {
    /**
     * Processes and writers data from args
     * @param args args[0] should be operation type (search or stat), args[1] input file path, args[2] output file path
     * @return object written to output file
     */
    OutputDto processAndWrite(String...args);
}
