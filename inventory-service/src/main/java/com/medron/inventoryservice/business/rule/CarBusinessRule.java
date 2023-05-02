package com.medron.inventoryservice.business.rule;

import com.medron.inventoryservice.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarBusinessRule {
    private final CarRepository repository;
}
