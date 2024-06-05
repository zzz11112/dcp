package com.dcp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DcpApplication {
	public static void main(String[] args) {
		SpringApplication.run(DcpApplication.class, args);
		log.info("Dcp Started Successfully");
	}

}
