package com.medron.rentalservice.api.client;

import com.medron.commonpackage.utils.dto.ClientResponse;
import com.medron.commonpackage.utils.dto.PaymentRentalRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service",fallback = PaymentClientFallback.class)
public interface PaymentClient {

    @PostMapping("/payment/pay")
    ClientResponse pay(@RequestBody PaymentRentalRequest request);
}
