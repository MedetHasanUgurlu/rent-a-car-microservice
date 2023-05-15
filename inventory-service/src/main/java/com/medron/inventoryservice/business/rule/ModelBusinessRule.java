package com.medron.inventoryservice.business.rule;

import com.medron.commonpackage.constant.ExceptionConstant;
import com.medron.commonpackage.exception.exceptions.BusinessException;
import com.medron.inventoryservice.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ModelBusinessRule {
    private final ModelRepository repository;

    public void checkEntityExist(UUID id){
        if(!repository.existsById(id)){
            throw new BusinessException(ExceptionConstant.Model.MODEL_ENTITY_NOT_EXIST);
        }
    }
    public void checkNameExist(String name){
        if (repository.existsByNameIgnoreCase(name)) {
            throw new IllegalArgumentException("Brand name already used.");
        }
    }
}
