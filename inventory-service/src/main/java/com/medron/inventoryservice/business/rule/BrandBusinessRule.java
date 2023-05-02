package com.medron.inventoryservice.business.rule;

import com.medron.inventoryservice.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BrandBusinessRule {
    private final BrandRepository repository;

    public void checkNameExist(String name){
        if (!repository.existsByNameIgnoreCase(name)) {
            throw new IllegalArgumentException("Brand name already used.");
        }

    }
    public void checkEntityExist(UUID id){
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("Entity not found.");

        }
    }
}
