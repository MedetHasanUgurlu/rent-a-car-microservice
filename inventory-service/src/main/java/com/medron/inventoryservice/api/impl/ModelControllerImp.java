package com.medron.inventoryservice.api.impl;

import com.medron.inventoryservice.api.ModelController;
import com.medron.inventoryservice.business.ModelService;
import com.medron.inventoryservice.business.dto.request.create.ModelCreateRequest;
import com.medron.inventoryservice.business.dto.request.update.ModelUpdateRequest;
import com.medron.inventoryservice.business.dto.response.get.ModelGetResponse;
import com.medron.inventoryservice.business.dto.response.getall.ModelGetAllResponse;
import com.medron.inventoryservice.constant.PathConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(PathConstant.Model.BasePath)
public class ModelControllerImp implements ModelController {
    private final ModelService service;
    @Override
    @PostMapping
    public ResponseEntity<Void> add(@RequestBody ModelCreateRequest request) {
        service.add(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody ModelUpdateRequest request) {
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
    public ResponseEntity<ModelGetResponse> get(@PathVariable UUID id) {
        return new ResponseEntity<>(service.get(id),HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ModelGetAllResponse>> getAll() {
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }
}
