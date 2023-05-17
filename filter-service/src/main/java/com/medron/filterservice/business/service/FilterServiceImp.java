package com.medron.filterservice.business.service;

import com.medron.filterservice.business.FilterService;
import com.medron.filterservice.business.dto.FilterGetAllResponse;
import com.medron.filterservice.business.dto.FilterGetResponse;
import com.medron.filterservice.entity.Filter;
import com.medron.filterservice.repository.FilterRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FilterServiceImp implements FilterService {
    private final FilterRepository repository;
    private final ModelMapper mapper;

    List<FilterGetAllResponse> entityListToDtoList(List<Filter> list){
        return list.stream().map(filter -> mapper.map(filter, FilterGetAllResponse.class)).toList();
    }
    FilterGetResponse entityToDto(Filter filter){
        return mapper.map(filter,FilterGetResponse.class);
    }
    @Override
    public List<FilterGetAllResponse> getAll() {
        return entityListToDtoList(repository.findAll());
    }

    @Override
    public FilterGetResponse get(String id) {
        return entityToDto(repository.findById(id).orElseThrow());
    }

    @Override
    public void add(Filter filter) {
        repository.save(filter);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteCar(UUID carId) {
        repository.deleteByCarId(carId);
    }

    @Override
    public void deleteAllBrand(UUID brandId) {
        repository.deleteAllByBrandId(brandId);
    }

    @Override
    public void deleteAllModel(UUID modelId) {
        repository.deleteAllByModelId(modelId);
    }
    @Override
    public Filter findByCar(UUID carId){
        return repository.findByCarId(carId).orElseThrow();
    }
}
