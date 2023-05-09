package com.medron.filterservice.api;

import com.medron.filterservice.business.dto.response.FilterGetAllResponse;
import com.medron.filterservice.business.dto.response.FilterGetResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface FilterController {
    ResponseEntity<FilterGetResponse> getById(UUID id);
    ResponseEntity<List<FilterGetAllResponse>> getAll();
    ResponseEntity<Void> delete(UUID id);
    ResponseEntity<Void> deleteAllBrand(UUID brandId);
    ResponseEntity<Void> deleteAllModel(UUID modelId);
}
