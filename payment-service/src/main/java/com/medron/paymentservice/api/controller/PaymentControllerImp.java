package com.medron.paymentservice.api.controller;

import com.medron.commonpackage.utils.dto.ClientResponse;
import com.medron.paymentservice.business.dto.request.PaymentCreateRequest;
import com.medron.commonpackage.utils.dto.PaymentRentalRequest;
import com.medron.paymentservice.business.dto.request.PaymentUpdateRequest;
import com.medron.paymentservice.business.dto.response.PaymentGetAllResponse;
import com.medron.paymentservice.business.dto.response.PaymentGetResponse;
import com.medron.paymentservice.business.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")

public class PaymentControllerImp implements PaymentController{
    private final PaymentService service;
    @Override
    @PostMapping
    public ResponseEntity<Void> add(@Valid @RequestBody PaymentCreateRequest request) {
        service.add(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<PaymentGetResponse> get(@PathVariable UUID id) {
        return new ResponseEntity<>(service.get(id),HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<PaymentGetAllResponse>> getAll() {
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody PaymentUpdateRequest request) {
        service.update(id, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @PostMapping("/pay")
    public ResponseEntity<ClientResponse> pay(@RequestBody PaymentRentalRequest request) {
        return new ResponseEntity<>(service.pay(request),HttpStatus.OK);
    }
}
