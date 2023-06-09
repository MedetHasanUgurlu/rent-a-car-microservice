package com.medron.inventoryservice.api.impl;

import com.medron.commonpackage.utils.dto.ClientCarFeatureResponse;
import com.medron.commonpackage.utils.dto.ClientResponse;
import com.medron.commonpackage.utils.dto.ClientResponseStatus;
import com.medron.inventoryservice.api.CarController;
import com.medron.inventoryservice.business.CarService;
import com.medron.inventoryservice.business.dto.request.create.CarCreateRequest;
import com.medron.inventoryservice.business.dto.request.update.CarUpdateRequest;
import com.medron.inventoryservice.business.dto.response.get.CarGetResponse;
import com.medron.inventoryservice.business.dto.response.getall.CarGetAllResponse;
import com.medron.commonpackage.constant.URLPathConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping(URLPathConstant.Car.BasePath)
public class CarControllerImp implements CarController {
    private final CarService service;

    @GetMapping("/test")
    public String test(){
        return "test";
    }
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
    @Secured("ROLE_admin")
    public ResponseEntity<List<CarGetAllResponse>> getAll() {
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @Override
    @GetMapping("/check-car-available/{id}")
    public ResponseEntity<ClientResponse> checkCarAvailable(@PathVariable UUID id) {
        return new ResponseEntity<>(service.checkCarAvailable(id),HttpStatus.OK);
    }

    @Override
    @GetMapping("/show-state/{id}")
    public ResponseEntity<ClientResponseStatus> showState(@PathVariable UUID id) {
        return new ResponseEntity<>(service.showState(id),HttpStatus.OK);
    }

    @Override
    @GetMapping("/car-feature/{id}")
    public ResponseEntity<ClientCarFeatureResponse> getCarFeature(@PathVariable UUID id) {
        return new ResponseEntity<>(service.getCarFeature(id),HttpStatus.OK);
    }
}
