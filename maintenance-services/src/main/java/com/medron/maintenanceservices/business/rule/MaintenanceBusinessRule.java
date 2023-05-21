package com.medron.maintenanceservices.business.rule;

import com.medron.commonpackage.exception.exceptions.BusinessException;
import com.medron.commonpackage.utils.dto.ClientResponse;
import com.medron.maintenanceservices.api.client.CarClient;
import com.medron.maintenanceservices.repository.MaintenanceRepository;
import feign.Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class MaintenanceBusinessRule {
    private final MaintenanceRepository repository;
    private final CarClient carClient;

    public void checkEntityExist(UUID id){
        if (repository.findById(id).isEmpty()){
            throw new BusinessException("Entity not exist");
        }
    }
    public void checkCarAvailableForMaintenance(UUID carId){
        ClientResponse response = carClient.checkCarAvailable(carId);
        if(response.isSuccess()){
            log.info("<===== CAR-AVAILABLE ======>");
        }else{
            throw new BusinessException("Car not available");
        }

    }
    public void checkCarForReturn(UUID carId){
        if(!repository.existsByCarIdAndIsCompletedIsFalse(carId)){
            log.info("<===== CAR-NOT-IN-DB-OR-CAR-NOT-MAINTENANCE ======>");
        }
    }
}
