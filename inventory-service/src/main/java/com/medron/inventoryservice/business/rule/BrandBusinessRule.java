package com.medron.inventoryservice.business.rule;

import com.medron.inventoryservice.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandBusinessRule {
    private final BrandRepository repository;
}
