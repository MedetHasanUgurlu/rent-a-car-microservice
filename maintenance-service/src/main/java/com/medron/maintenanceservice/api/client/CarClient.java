package com.medron.maintenanceservice.api.client;

import com.medron.commonpackage.utils.dto.ClientResponse;
import com.medron.commonpackage.utils.dto.ClientResponseStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "inventory-service")
public interface CarClient {
    @GetMapping(value = "/api/v1/car/check-car-available/{carId}")
    ClientResponse checkCarAvailable(@PathVariable UUID carId);
    @GetMapping(value = "/api/v1/car/show-state/{carId}")
    ClientResponseStatus getState(@PathVariable UUID carId);

    // TODO: Neden mikroservis kullanırız?
    // TODO: ****SOAP****, SOA
    // TODO: Design Pattern, Refactoring Guru
    // TODO: ****UnitTest****, JaCoCo(80-90)coverege, Mocking(I/O)
    // TODO: YAZILIM MÜHENDİSLİĞİ


    // TODO: Outsource nedir?
    // TODO: Danışmanlık Modeli
}
