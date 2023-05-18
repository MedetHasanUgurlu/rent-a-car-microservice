package com.medron.rentalservice.api.client;

import com.medron.commonpackage.utils.dto.ClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "inventory-service",fallback = CarClientFallback.class)
public interface CarClient {

    @GetMapping(value = "/api/v1/car/{id}")
    ClientResponse checkCarAvailable(@PathVariable UUID id);

}
