package com.larkinds.aikamtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.larkinds.aikamtest.deserializer.SearchDeserializer;
import com.larkinds.aikamtest.dto.fromjson.input.SearchDto;
import com.larkinds.aikamtest.repository.CustomerRepository;
import com.larkinds.aikamtest.repository.PurchaseRepository;
import com.larkinds.aikamtest.repository.StatRepository;
import com.larkinds.aikamtest.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class AikamtestApplication implements CommandLineRunner {
	@Autowired
	MainService mainService;
	@Autowired
	PurchaseRepository purchaseRepository;
	public static void main(String[] args) {
		SpringApplication.run(AikamtestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (args.length == 3) mainService.processAndWrite(args);
		else log.warn("args.length !=3");
	}
}
