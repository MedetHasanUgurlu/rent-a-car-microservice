package com.medron.inventoryservice.business;

import com.medron.inventoryservice.business.dto.request.create.BrandCreateRequest;
import com.medron.inventoryservice.business.dto.request.create.ModelCreateRequest;
import com.medron.inventoryservice.business.dto.request.update.BrandUpdateRequest;
import com.medron.inventoryservice.business.dto.request.update.ModelUpdateRequest;
import com.medron.inventoryservice.business.dto.response.get.BrandGetResponse;
import com.medron.inventoryservice.business.dto.response.get.ModelGetResponse;
import com.medron.inventoryservice.business.dto.response.getall.ModelGetAllResponse;

import java.util.List;
import java.util.UUID;

public interface ModelService {
    void add(ModelCreateRequest request);
    List<ModelGetAllResponse> getAll();
    ModelGetResponse get(UUID id);
    void update(UUID id, ModelUpdateRequest request);
    void delete(UUID id);

}
