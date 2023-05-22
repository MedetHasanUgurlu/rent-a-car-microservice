package com.medron.paymentservice.api.controller;

import com.medron.paymentservice.business.dto.request.PaymentCreateRequest;
import com.medron.paymentservice.business.dto.request.PaymentRentalRequest;
import com.medron.paymentservice.business.dto.request.PaymentUpdateRequest;
import com.medron.paymentservice.business.dto.response.PaymentGetAllResponse;
import com.medron.paymentservice.business.dto.response.PaymentGetResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface PaymentController {
    ResponseEntity<Void> add(PaymentCreateRequest request);
    ResponseEntity<PaymentGetResponse> get(UUID id);
    ResponseEntity<Void> delete(UUID id);
    ResponseEntity<List<PaymentGetAllResponse>> getAll();
    ResponseEntity<Void> update(UUID id, PaymentUpdateRequest request);
    ResponseEntity<Void> pay(PaymentRentalRequest request);
}
