package com.medron.rentalservice;

import com.medron.commonpackage.constant.PathConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {PathConstant.ConfigurationBasePackage,PathConstant.Rental.ServiceBasePackage})
public class RentalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalServiceApplication.class, args);
	}

}
