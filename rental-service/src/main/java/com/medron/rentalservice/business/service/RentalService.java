package com.medron.rentalservice.business.service;

import com.medron.rentalservice.business.dto.request.RentalCreateRequest;
import com.medron.rentalservice.business.dto.request.RentalUpdateRequest;
import com.medron.rentalservice.business.dto.response.RentalGetAllResponse;
import com.medron.rentalservice.business.dto.response.RentalGetResponse;

import java.util.UUID;
import java.util.List;

public interface RentalService {
    void add(RentalCreateRequest request);
    void delete(UUID id);
    void update(UUID id,RentalUpdateRequest request);
    RentalGetResponse get(UUID id);
    List<RentalGetAllResponse> getAll();
    void returnFromRented(UUID id);
}
