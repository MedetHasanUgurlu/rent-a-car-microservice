package com.medron.maintenanceservice.api.controller;

import com.medron.maintenanceservice.business.dto.request.MaintenanceCreateRequest;
import com.medron.maintenanceservice.business.dto.request.MaintenanceUpdateRequest;
import com.medron.maintenanceservice.business.dto.response.MaintenanceGetAllResponse;
import com.medron.maintenanceservice.business.dto.response.MaintenanceGetResponse;
import com.medron.maintenanceservice.business.service.MaintenanceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/maintenance")
public class MaintenanceControllerImp implements MaintenanceController{
    private final MaintenanceService service;

    @Override
    @PostMapping
    public ResponseEntity<Void> add(@Valid @RequestBody MaintenanceCreateRequest request) {
        service.add(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable UUID id, @Valid @RequestBody MaintenanceUpdateRequest request) {
        service.update(id,request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<MaintenanceGetResponse> get(@PathVariable UUID id) {
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<MaintenanceGetAllResponse>> getAll() {
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }
}
