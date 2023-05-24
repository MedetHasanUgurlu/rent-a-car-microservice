package com.medron.rentalservice.api.client;

import com.medron.commonpackage.utils.dto.ClientResponse;
import com.medron.commonpackage.utils.dto.PaymentRentalRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentClientFallback implements PaymentClient {
    @Override
    public ClientResponse pay(PaymentRentalRequest request) {
        log.info("[<=== PAYMENT_CLIENT_FALLBACK ===>]");
        return new ClientResponse(false,"FAILED");
    }
}
