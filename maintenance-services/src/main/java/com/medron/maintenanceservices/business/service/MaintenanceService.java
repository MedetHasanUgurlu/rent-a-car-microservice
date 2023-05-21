package com.medron.maintenanceservices.business.service;

import com.medron.maintenanceservices.business.dto.request.MaintenanceCreateRequest;
import com.medron.maintenanceservices.business.dto.request.MaintenanceUpdateRequest;
import com.medron.maintenanceservices.business.dto.response.MaintenanceGetAllResponse;
import com.medron.maintenanceservices.business.dto.response.MaintenanceGetResponse;

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

