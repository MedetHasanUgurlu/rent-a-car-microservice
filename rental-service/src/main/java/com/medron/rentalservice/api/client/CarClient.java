package com.medron.rentalservice.api.client;

import com.medron.commonpackage.utils.dto.ClientCarFeatureResponse;
import com.medron.commonpackage.utils.dto.ClientResponse;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "inventory-service" ,fallback = CarClientFallback.class)
public interface CarClient {


    @Retry(name = "inventory-service-retry")
    @GetMapping(value = "/api/v1/car/check-car-available/{id}")
    ClientResponse checkCarAvailable(@PathVariable UUID id);

    @GetMapping(value = "/api/v1/car/car-feature/{id}")
    ClientCarFeatureResponse getCarFeature(@PathVariable UUID id);


}

