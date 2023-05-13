package com.medron.filterservice.business.service.impl;

import com.medron.commonpackage.utils.mapper.ModelMapperService;
import com.medron.filterservice.business.dto.response.FilterGetAllResponse;
import com.medron.filterservice.business.dto.response.FilterGetResponse;
import com.medron.filterservice.business.service.FilterService;
import com.medron.filterservice.entity.Filter;
import com.medron.filterservice.repository.FilterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class FilterServiceImp implements FilterService {
    private final FilterRepository repository;
    private final ModelMapperService modelMapperService;

    List<FilterGetAllResponse> entityToGetAllResponse(List<Filter> list){
        return list.stream().map(filter -> modelMapperService.forResponse().map(filter,FilterGetAllResponse.class)).toList();
    }
    FilterGetResponse entityToGetResponse(Filter filter){
        return modelMapperService.forResponse().map(filter,FilterGetResponse.class);
    }
    @Override
    public List<FilterGetAllResponse> getAll() {
        return entityToGetAllResponse(repository.findAll());
    }

    @Override
    public FilterGetResponse get(UUID id) {
        return entityToGetResponse(repository.findById(id).orElseThrow());
    }

    @Override
    public void add(Filter filter) {
        repository.save(filter);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAllBrandId(UUID brandId) {

    }

    @Override
    public void deleteAllModelId(UUID modelId) {

    }
}
