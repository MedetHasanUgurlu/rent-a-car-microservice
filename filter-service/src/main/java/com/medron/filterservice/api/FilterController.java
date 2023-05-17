package com.medron.filterservice.api;

import com.medron.filterservice.business.dto.FilterGetAllResponse;
import com.medron.filterservice.business.dto.FilterGetResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface FilterController {
    ResponseEntity<List<FilterGetAllResponse>> getAll();
    ResponseEntity<FilterGetResponse> get(String id);
    ResponseEntity<Void> delete(String id);
    ResponseEntity<Void> deleteCar(UUID carId);
    ResponseEntity<Void> deleteAllBrand(UUID brandId);
    ResponseEntity<Void> deleteAllModel(UUID modelId);

}
