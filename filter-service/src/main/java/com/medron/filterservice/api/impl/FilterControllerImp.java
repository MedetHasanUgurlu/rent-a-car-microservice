package com.medron.filterservice.api.impl;

import com.medron.filterservice.api.FilterController;
import com.medron.filterservice.business.dto.response.FilterGetAllResponse;
import com.medron.filterservice.business.dto.response.FilterGetResponse;
import com.medron.filterservice.business.service.FilterService;
import com.medron.filterservice.entity.Filter;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/filter")
@RequiredArgsConstructor
public class FilterControllerImp implements FilterController {

    private final FilterService service;

    @PostConstruct
    public void createDb(){
        service.add(new Filter());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<FilterGetResponse> getById(@PathVariable UUID id) {
        return new ResponseEntity<>(service.get(id),HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<FilterGetAllResponse>> getAll() {
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }


    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Void> deleteAllBrand(@RequestParam UUID brandId) {
        service.deleteAllBrandId(brandId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteAllModel(UUID modelId) {
        service.deleteAllModelId(modelId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
