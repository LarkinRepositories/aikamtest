package com.larkinds.aikamtest;

import com.larkinds.aikamtest.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class AikamtestApplication implements CommandLineRunner {
	@Autowired
	MainService mainService;

	public static void main(String[] args) {
		SpringApplication.run(AikamtestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (args.length == 3) mainService.processAndWrite(args);
		else log.warn("args.length != 3");
	}
}
