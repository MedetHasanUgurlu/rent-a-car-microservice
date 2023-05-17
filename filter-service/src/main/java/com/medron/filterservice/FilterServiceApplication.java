package com.medron.filterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.medron.commonpackage.config","com.medron.filterservice"})
public class FilterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilterServiceApplication.class, args);
	}

}
