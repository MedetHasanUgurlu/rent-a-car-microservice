package com.medron.paymentservice.business.rule;

import com.medron.commonpackage.exception.exceptions.BusinessException;
import com.medron.paymentservice.entity.Payment;
import com.medron.paymentservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentBusinessRule {
    private final PaymentRepository repository;
    public void checkEntityExist(UUID id){
        if (repository.findById(id).isEmpty()) {
            throw new BusinessException("ENTITY NOT EXIST");
        }
    }

    public void checkCardInformation(Payment payment){
        repository
    }

}
