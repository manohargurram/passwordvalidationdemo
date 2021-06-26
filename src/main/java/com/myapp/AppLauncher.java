package com.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppLauncher {

	private static Logger logger = LoggerFactory.getLogger(AppLauncher.class);

	public static void main(String[] args) {
		SpringApplication.run(AppLauncher.class, args);
		logger.info("passwordvalidationdemo application started");
	}

}
