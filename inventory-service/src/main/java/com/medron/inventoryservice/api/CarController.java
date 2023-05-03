package com.medron.inventoryservice.api;

import com.medron.inventoryservice.business.dto.request.create.CarCreateRequest;
import com.medron.inventoryservice.business.dto.request.update.CarUpdateRequest;
import com.medron.inventoryservice.business.dto.response.get.CarGetResponse;
import com.medron.inventoryservice.business.dto.response.getall.CarGetAllResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface CarController {
    ResponseEntity<Void> add(CarCreateRequest request);
    ResponseEntity<Void> update(UUID id, CarUpdateRequest request);
    ResponseEntity<Void> delete(UUID id);
    ResponseEntity<CarGetResponse> get(UUID id);
    ResponseEntity<List<CarGetAllResponse>> getAll();
}
