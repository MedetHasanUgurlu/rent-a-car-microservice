package com.medron.rentalservice.business.rule;

import com.medron.commonpackage.exception.exceptions.BusinessException;
import com.medron.rentalservice.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RentalBusinessRule {
    private final RentalRepository repository;
    public void checkEntityExist(UUID id){
        if (!repository.existsById(id)){
            throw new BusinessException("Entiy not exist");
        }
    }
}
