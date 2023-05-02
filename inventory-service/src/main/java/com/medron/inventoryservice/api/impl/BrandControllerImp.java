package com.medron.inventoryservice.api.impl;

import com.medron.inventoryservice.api.BrandController;
import com.medron.inventoryservice.business.BrandService;
import com.medron.inventoryservice.business.dto.request.create.BrandCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/brand")
public class BrandControllerImp implements BrandController {
    private final BrandService brandService;

    @PostMapping
    public void create(@RequestBody BrandCreateRequest request){
        brandService.add(request);
    }

}
