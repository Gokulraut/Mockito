package com.csi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class JunitMockitoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JunitMockitoApplication.class, args);
	}

}
