package com.medron.inventoryservice;

import com.medron.commonpackage.constant.PathConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {PathConstant.ConfigurationBasePackage,PathConstant.Inventory.ServiceBasePackage})
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

}
