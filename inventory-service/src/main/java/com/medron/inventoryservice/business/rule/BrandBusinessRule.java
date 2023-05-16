package com.medron.inventoryservice.business.rule;

import com.medron.commonpackage.exception.exceptions.BusinessException;
import com.medron.inventoryservice.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BrandBusinessRule {
    private final BrandRepository repository;

    public void checkNameExist(String name){
        if (repository.existsByNameIgnoreCase(name)) {
            throw new BusinessException("BrandName already exist");
        }
    }
    public void checkEntityExist(UUID id){
        if(!repository.existsById(id)){
            throw new BusinessException("Brand not found");
        }
    }
}
