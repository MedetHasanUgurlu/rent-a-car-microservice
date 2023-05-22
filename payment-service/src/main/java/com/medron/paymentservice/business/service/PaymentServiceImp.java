package com.medron.paymentservice.business.service;


import com.medron.paymentservice.business.dto.request.PaymentCreateRequest;
import com.medron.paymentservice.business.dto.request.PaymentRentalRequest;
import com.medron.paymentservice.business.dto.request.PaymentRequest;
import com.medron.paymentservice.business.dto.request.PaymentUpdateRequest;
import com.medron.paymentservice.business.dto.response.PaymentGetAllResponse;
import com.medron.paymentservice.business.dto.response.PaymentGetResponse;
import com.medron.paymentservice.business.rule.PaymentBusinessRule;
import com.medron.paymentservice.entity.Payment;
import com.medron.paymentservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImp implements PaymentService{
    private final PaymentBusinessRule rule;
    private final PaymentRepository repository;
    private final ModelMapper mapper;

    Payment requestToEntity(PaymentRequest request){
        return mapper.map(request,Payment.class);
    }
    PaymentGetResponse entityPaymentGetResponse(Payment payment){
        return mapper.map(payment,PaymentGetResponse.class);
    }
    PaymentGetAllResponse entityToGetAllResponse(Payment payment){
        return mapper.map(payment,PaymentGetAllResponse.class);
    }

    @Override
    public void add(PaymentCreateRequest request) {
        rule.checkCardExist(request.getCardNumber());
        Payment payment = requestToEntity(request);
        payment.setId(UUID.randomUUID());
        repository.save(payment);
    }

    @Override
    public void delete(UUID id) {
        rule.checkEntityExist(id);
        repository.deleteById(id);
    }

    @Override
    public void update(UUID id,PaymentUpdateRequest request) {
        rule.checkEntityExist(id);
        Payment payment = repository.findById(id).orElseThrow();
        payment.setBalance(request.getBalance());
        payment.setCardHolder(request.getCardHolder());
        repository.save(payment);
    }

    @Override
    public PaymentGetResponse get(UUID id) {
        rule.checkEntityExist(id);
        return entityPaymentGetResponse(repository.findById(id).orElseThrow());
    }

    @Override
    public List<PaymentGetAllResponse> getAll() {
        return repository.findAll().stream().map(this::entityToGetAllResponse).toList();
    }

    @Override
    public void pay(PaymentRentalRequest request) {
        rule.checkCardExist(request.getCardNumber());
        Payment payment = repository.findByCardNumber(request.getCardNumber());
        rule.checkCardInformation(requestToEntity(request));
        rule.checkBalance(payment.getBalance(), request.getPrice());
        payment.setBalance(payment.getBalance()- request.getPrice());
        repository.save(payment);
    }
}
