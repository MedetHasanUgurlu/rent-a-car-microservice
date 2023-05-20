package com.medron.maintenanceservice.api.client;

import com.medron.commonpackage.utils.dto.ClientResponse;
import com.medron.commonpackage.utils.dto.ClientResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Slf4j
@Component
public class CarClientFallBack implements CarClient{
    @Override
    public ClientResponse checkCarAvailable(UUID id) {
        log.error("[FAILED] ==> "+id.toString());
        return ClientResponse.builder().isSuccess(false).message("").build();
    }

    @Override
    public ClientResponseStatus getState(UUID id) {
        log.error("[FAILED] ==> "+id.toString());
        return ClientResponseStatus.builder().state("null").build();
    }
}
