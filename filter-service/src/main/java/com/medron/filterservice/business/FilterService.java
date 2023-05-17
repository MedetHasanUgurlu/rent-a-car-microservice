package com.medron.filterservice.business;

import com.medron.filterservice.business.dto.FilterGetAllResponse;
import com.medron.filterservice.business.dto.FilterGetResponse;
import com.medron.filterservice.entity.Filter;

import java.util.List;
import java.util.UUID;

public interface FilterService {
    List<FilterGetAllResponse> getAll();
    FilterGetResponse get(String id);
    void add(Filter filter);
    void delete(String id);
    void deleteCar(UUID carId);
    void deleteAllBrand(UUID brandId);
    void deleteAllModel(UUID modelId);
    Filter findByCar(UUID carId);
}
