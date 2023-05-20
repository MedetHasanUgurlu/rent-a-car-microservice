package com.medron.maintenanceservice.api.controller;

import com.medron.maintenanceservice.business.dto.request.MaintenanceCreateRequest;
import com.medron.maintenanceservice.business.dto.request.MaintenanceUpdateRequest;
import com.medron.maintenanceservice.business.dto.response.MaintenanceGetAllResponse;
import com.medron.maintenanceservice.business.dto.response.MaintenanceGetResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface MaintenanceController {
    ResponseEntity<Void> add(MaintenanceCreateRequest request);
    ResponseEntity<Void> delete(UUID id);
    ResponseEntity<Void> update(UUID id, MaintenanceUpdateRequest request);
    ResponseEntity<MaintenanceGetResponse> get(UUID id);
    ResponseEntity<List<MaintenanceGetAllResponse>> getAll();
}
