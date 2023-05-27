package com.medron.inventoryservice.business;


import com.medron.commonpackage.utils.dto.ClientCarFeatureResponse;
import com.medron.commonpackage.utils.dto.ClientResponse;
import com.medron.commonpackage.utils.dto.ClientResponseStatus;
import com.medron.inventoryservice.business.dto.request.create.CarCreateRequest;
import com.medron.inventoryservice.business.dto.request.update.CarUpdateRequest;
import com.medron.inventoryservice.business.dto.response.get.CarGetResponse;
import com.medron.inventoryservice.business.dto.response.getall.CarGetAllResponse;
import com.medron.inventoryservice.entity.enums.State;

import java.util.List;
import java.util.UUID;

public interface CarService {
    void add(CarCreateRequest request);
    List<CarGetAllResponse> getAll();
    CarGetResponse get(UUID id);
    void update(UUID id, CarUpdateRequest request);
    void delete(UUID id);
    ClientResponse checkCarAvailable(UUID id);
    void changeStatus(UUID id, State state);
    ClientResponseStatus showState(UUID id);
    ClientCarFeatureResponse getCarFeature(UUID carId);
}
