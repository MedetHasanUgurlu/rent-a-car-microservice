package com.medron.inventoryservice.business;

import com.medron.inventoryservice.business.dto.request.create.BrandCreateRequest;
import com.medron.inventoryservice.business.dto.request.update.BrandUpdateRequest;
import com.medron.inventoryservice.business.dto.response.get.BrandGetResponse;
import com.medron.inventoryservice.business.dto.response.getall.BrandGetAllResponse;

import java.util.List;
import java.util.UUID;

public interface BrandService {
    void add(BrandCreateRequest request);
    List<BrandGetAllResponse> getAll();
    BrandGetResponse get(UUID id);
    void update(UUID id, BrandUpdateRequest request);
    void delete(UUID id);

}
