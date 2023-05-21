package com.medron.maintenanceservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication(scanBasePackages = {"com.medron.commonpackage.config","com.medron.maintenanceservices"})
public class MaintenanceServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaintenanceServicesApplication.class, args);
	}

}
