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
        if(!repository.existsByCardNumberAndCardHolderAndCardExpirationYearAndCardExpirationMonthAndCardCvv(
                payment.getCardNumber(),
                payment.getCardHolder(),
                payment.getCardExpirationYear(),
                payment.getCardExpirationMonth(),
                payment.getCardCvv())){
            throw new BusinessException("CAN NOT FOUND CARD INFORMATION");
        }
    }

    public void checkCardExist(String cardNumber){
        if (repository.existsByCardNumber(cardNumber)){
            throw new BusinessException("CARD_ALREADY_EXIST");
        }
    }

    public void checkBalance(double balance,double price){
        if(price>balance){
            throw new BusinessException("PRICE > BALANCE");
        }
    }



}
