package com.medron.inventoryservice.business.rule;


import com.medron.commonpackage.constant.ExceptionConstant;
import com.medron.commonpackage.exception.exceptions.BusinessException;
import com.medron.inventoryservice.entity.enums.State;
import com.medron.inventoryservice.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarBusinessRule {
    private final CarRepository repository;
    public void checkEntityExist(UUID id){
        if(repository.findById(id).isEmpty()){
            throw new BusinessException(ExceptionConstant.Car.CAR_ENTITY_NOT_EXIST);
        }
    }
    //Single Response
    //Open closed
    //List
    // OLID
    public void checkPlateExist(String plate){
        if(repository.existsByPlateIsIgnoreCase(plate)){
            throw new BusinessException(ExceptionConstant.Car.CAR_PLATE_EXIST);
        }
    }

    public void checkCarAvailable(UUID id){
        checkEntityExist(id);
        if(repository.findById(id).orElseThrow().getState() != State.Available){
            throw new BusinessException(ExceptionConstant.Car.CAR_NOT_AVAILABLE);
        }
    }



}
