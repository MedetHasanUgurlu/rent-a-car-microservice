package com.medron.inventoryservice.api.impl;

import com.medron.inventoryservice.api.BrandController;
import com.medron.inventoryservice.business.BrandService;
import com.medron.inventoryservice.business.dto.request.create.BrandCreateRequest;
import com.medron.inventoryservice.business.dto.request.update.BrandUpdateRequest;
import com.medron.inventoryservice.business.dto.response.get.BrandGetResponse;
import com.medron.inventoryservice.business.dto.response.getall.BrandGetAllResponse;
import com.medron.inventoryservice.constant.PathConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(PathConstant.Brand.BasePath)
public class BrandControllerImp implements BrandController {
    private final BrandService brandService;



    @Override
    @PostMapping
    public ResponseEntity<Void> add(@RequestBody BrandCreateRequest request) {
        brandService.add(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody BrandUpdateRequest request) {
        brandService.update(id,request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        brandService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<BrandGetResponse> get(@PathVariable UUID id) {
        return new ResponseEntity<>(brandService.get(id),HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<BrandGetAllResponse>> getAll() {
        return new ResponseEntity<>(brandService.getAll(),HttpStatus.OK);
    }
}
