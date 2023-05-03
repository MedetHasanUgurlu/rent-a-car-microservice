package com.medron.inventoryservice.api;

import com.medron.inventoryservice.business.dto.request.create.ModelCreateRequest;
import com.medron.inventoryservice.business.dto.request.update.ModelUpdateRequest;
import com.medron.inventoryservice.business.dto.response.get.ModelGetResponse;
import com.medron.inventoryservice.business.dto.response.getall.ModelGetAllResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ModelController {
    ResponseEntity<Void> add(ModelCreateRequest request);
    ResponseEntity<Void> update(UUID id, ModelUpdateRequest request);
    ResponseEntity<Void> delete(UUID id);
    ModelGetResponse get(UUID id);
    ResponseEntity<List<ModelGetAllResponse>> getAll();
}
