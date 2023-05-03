package com.medron.inventoryservice.api.impl;

import com.medron.inventoryservice.api.CarController;
import com.medron.inventoryservice.business.CarService;
import com.medron.inventoryservice.business.dto.request.create.CarCreateRequest;
import com.medron.inventoryservice.business.dto.request.update.CarUpdateRequest;
import com.medron.inventoryservice.business.dto.response.get.CarGetResponse;
import com.medron.inventoryservice.business.dto.response.getall.CarGetAllResponse;
import com.medron.inventoryservice.constant.PathConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(PathConstant.Car.BasePath)
public class CarControllerImp implements CarController {
    private final CarService service;

    @Override
    @PostMapping
    public ResponseEntity<Void> add(@RequestBody CarCreateRequest request) {
        service.add(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody CarUpdateRequest request) {
        service.update(id,request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CarGetResponse> get(@PathVariable UUID id) {
        return new ResponseEntity<>(service.get(id),HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CarGetAllResponse>> getAll() {
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }
}
