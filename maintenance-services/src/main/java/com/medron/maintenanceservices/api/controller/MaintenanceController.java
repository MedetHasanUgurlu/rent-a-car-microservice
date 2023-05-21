package com.medron.maintenanceservices.api.controller;

import com.medron.maintenanceservices.business.dto.request.MaintenanceCreateRequest;
import com.medron.maintenanceservices.business.dto.request.MaintenanceUpdateRequest;
import com.medron.maintenanceservices.business.dto.response.MaintenanceGetAllResponse;
import com.medron.maintenanceservices.business.dto.response.MaintenanceGetResponse;
import com.medron.maintenanceservices.business.service.MaintenanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/maintenance")
public class MaintenanceController {
    private final MaintenanceService service;
    @PostMapping
    public void add(@RequestBody MaintenanceCreateRequest request){
        service.add(request);
    }
    @GetMapping("/{id}")
    public MaintenanceGetResponse get(@PathVariable UUID id){
        return service.getById(id);

    }
    @GetMapping
    public List<MaintenanceGetAllResponse> getAll(){
        return service.getAll();
    }
    @GetMapping("/return/{carId}")
    public void returnMaintenance(@PathVariable UUID carId){
        service.returnCarFromMaintenance(carId);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        service.delete(id);
    }
    @PutMapping
    public void delete(@PathVariable UUID id,@RequestBody MaintenanceUpdateRequest request){
        service.update(id,request);
    }


}
