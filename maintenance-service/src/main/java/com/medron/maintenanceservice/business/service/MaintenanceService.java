package com.medron.maintenanceservice.business.service;

import com.medron.maintenanceservice.business.dto.request.MaintenanceCreateRequest;
import com.medron.maintenanceservice.business.dto.request.MaintenanceUpdateRequest;
import com.medron.maintenanceservice.business.dto.response.MaintenanceGetAllResponse;
import com.medron.maintenanceservice.business.dto.response.MaintenanceGetResponse;

import java.util.List;
import java.util.UUID;

public interface MaintenanceService {
    List<MaintenanceGetAllResponse> getAll();
    MaintenanceGetResponse getById(UUID id);
    void returnCarFromMaintenance(UUID carId);
    void add(MaintenanceCreateRequest request);
    void update(UUID id, MaintenanceUpdateRequest request);
    void delete(UUID id);
}
