package com.medron.paymentservice.business.service;

import com.medron.paymentservice.business.dto.request.PaymentCreateRequest;
import com.medron.paymentservice.business.dto.request.PaymentRentalRequest;
import com.medron.paymentservice.business.dto.request.PaymentUpdateRequest;
import com.medron.paymentservice.business.dto.response.PaymentGetAllResponse;
import com.medron.paymentservice.business.dto.response.PaymentGetResponse;

import java.util.List;
import java.util.UUID;

public interface PaymentService {
    void add(PaymentCreateRequest request);
    void delete(UUID id);
    void update(UUID id,PaymentUpdateRequest request);
    PaymentGetResponse get(UUID id);
    List<PaymentGetAllResponse> getAll();
    void pay(PaymentRentalRequest request);
}


