package com.medron.rentalservice.api;

import com.medron.rentalservice.business.dto.request.RentalCreateRequest;
import com.medron.rentalservice.business.dto.request.RentalUpdateRequest;
import com.medron.rentalservice.business.dto.response.RentalGetAllResponse;
import com.medron.rentalservice.business.dto.response.RentalGetResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface RentalController {
    ResponseEntity<Void> add(RentalCreateRequest request);
    ResponseEntity<RentalGetResponse> get(UUID id);
    ResponseEntity<List<RentalGetAllResponse>> getAll();
    ResponseEntity<Void> delete(UUID id);
    ResponseEntity<Void> update(UUID id, RentalUpdateRequest  request);

}
