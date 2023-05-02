package com.medron.inventoryservice.business.rule;

import com.medron.inventoryservice.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelBusinessRule {
    private final ModelRepository repository;
}
