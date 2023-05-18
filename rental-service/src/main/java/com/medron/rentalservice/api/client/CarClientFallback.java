package com.medron.rentalservice.api.client;

import com.medron.commonpackage.utils.dto.ClientResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class CarClientFallback implements CarClient{
    @Override
    public ClientResponse checkCarAvailable(UUID id) {
        log.info("[CAR-CLIENT-FALLBACK-IS-ON]");
        return null;
    }
}
