package com.medron.inventoryservice.api;

import com.medron.inventoryservice.business.dto.request.create.BrandCreateRequest;
import com.medron.inventoryservice.business.dto.request.update.BrandUpdateRequest;
import com.medron.inventoryservice.business.dto.response.get.BrandGetResponse;
import com.medron.inventoryservice.business.dto.response.getall.BrandGetAllResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface BrandController {
    ResponseEntity<Void> add(BrandCreateRequest request);
    ResponseEntity<Void> update(UUID id,BrandUpdateRequest request);
    ResponseEntity<Void> delete(UUID id);
    ResponseEntity<BrandGetResponse> get(UUID id);
    ResponseEntity<List<BrandGetAllResponse>> getAll();
}
