package com.medron.filterservice.api.imp;

import com.medron.filterservice.api.FilterController;
import com.medron.filterservice.business.FilterService;
import com.medron.filterservice.business.dto.FilterGetAllResponse;
import com.medron.filterservice.business.dto.FilterGetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/filter")
public class FilterControllerImp implements FilterController {
    private final FilterService service;
        @GetMapping("/test")
        String test(){
            return "test";
        }


    @Override
    @GetMapping
    public ResponseEntity<List<FilterGetAllResponse>> getAll() {
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<FilterGetResponse> get(@PathVariable String id) {
        return new ResponseEntity<>(service.get(id),HttpStatus.OK);

    }

    @Override
    @DeleteMapping("/{id}")

    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteCar(UUID carId) {
        service.deleteCar(carId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteAllBrand(UUID brandId) {
        service.deleteAllBrand(brandId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteAllModel(UUID modelId) {
        service.deleteAllModel(modelId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
