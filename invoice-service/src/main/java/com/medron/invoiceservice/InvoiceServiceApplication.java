package com.medron.invoiceservice;

import com.medron.invoiceservice.business.dto.InvoiceGetResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.medron.commonpackage.config","com.medron.invoiceservice"})
public class InvoiceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceServiceApplication.class, args);

	}

}
