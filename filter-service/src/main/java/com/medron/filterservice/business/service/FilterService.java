package com.medron.filterservice.business.service;

import com.medron.filterservice.business.dto.response.FilterGetAllResponse;
import com.medron.filterservice.business.dto.response.FilterGetResponse;
import com.medron.filterservice.entity.Filter;

import java.util.List;
import java.util.UUID;

public interface FilterService {
    List<FilterGetAllResponse> getAll();
    FilterGetResponse get(UUID id);
    void add(Filter filter);
    void delete(UUID id);
    void deleteAllBrandId(UUID brandId);
    void deleteAllModelId(UUID modelId);

}
