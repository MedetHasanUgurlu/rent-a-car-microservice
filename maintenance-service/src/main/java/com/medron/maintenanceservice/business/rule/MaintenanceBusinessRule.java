package com.medron.maintenanceservice.business.rule;

import com.medron.commonpackage.exception.exceptions.BusinessException;
import com.medron.commonpackage.utils.dto.ClientResponse;
import com.medron.maintenanceservice.api.client.CarClient;
import com.medron.maintenanceservice.repository.MaintenanceRepository;
import feign.Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class MaintenanceBusinessRule {
    private final CarClient carClient;
    private final MaintenanceRepository repository;

    public void checkEntityExist(UUID id){
        if(repository.findById(id).isEmpty()){
            log.error("[MAINTENANCE NOT EXIST]");
            throw new BusinessException("[MAINTENANCE NOT EXIST]");
        }
    }
    public void checkCarAvailableForMaintenance(UUID carId){
        ClientResponse response = carClient.checkCarAvailable(carId);
        if(response.isSuccess()){
            log.info("[SUCCESS OPERATION]");
        }else {
            throw new BusinessException(response.getMessage()+" [State]:  "+carClient.getState(carId).toString());
        }
    }

    public void checkCarForReturn(UUID carId){
        if(!repository.existsByCarIdAndIsCompletedIsFalse(carId)){
            throw new BusinessException("OPERATION FAILED => CAR IS NOT EXIST OR IS ALREADY MAINTENANCE");
        }

    }


}
