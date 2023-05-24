package com.medron.rentalservice.business.rule;

import com.medron.commonpackage.exception.exceptions.BusinessException;
import com.medron.commonpackage.utils.dto.ClientResponse;
import com.medron.commonpackage.utils.dto.PaymentRentalRequest;
import com.medron.rentalservice.api.client.CarClient;
import com.medron.rentalservice.api.client.PaymentClient;
import com.medron.rentalservice.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Slf4j
@Service
@RequiredArgsConstructor
public class RentalBusinessRule {
    private final RentalRepository repository;
    @Qualifier("com.medron.rentalservice.api.client.PaymentClient")
    private final PaymentClient paymentClient;
    @Qualifier("com.medron.rentalservice.api.client.CarClient")
    private final CarClient carClient;
    public void checkEntityExist(UUID id){
        if (!repository.existsById(id)){
            throw new BusinessException("Entity not exist");
        }
    }

    public void checkCarAvailable(UUID carId){
       ClientResponse response =  carClient.checkCarAvailable(carId);
        if(response.isSuccess()){
            log.info("[SUCCESS]");
        }else{
            throw new BusinessException("CAR_NOT_AVAILABLE");
        }
    }

    public void checkPayment(PaymentRentalRequest request){
        ClientResponse response = paymentClient.pay(request);
        if(!response.isSuccess()){
            throw new BusinessException("PAYMENT_FAILED");
        }

    }
}
