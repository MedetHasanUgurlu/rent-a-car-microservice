package com.medron.inventoryservice.business.impl;

import com.medron.inventoryservice.business.CarService;
import com.medron.inventoryservice.business.dto.abstracts.CarRequest;
import com.medron.inventoryservice.business.dto.request.create.CarCreateRequest;
import com.medron.inventoryservice.business.dto.request.update.CarUpdateRequest;
import com.medron.inventoryservice.business.dto.response.get.CarGetResponse;
import com.medron.inventoryservice.business.dto.response.getall.CarGetAllResponse;
import com.medron.inventoryservice.business.rule.CarBusinessRule;
import com.medron.inventoryservice.entity.Car;
import com.medron.inventoryservice.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarServiceImp implements CarService {
    private final CarRepository repository;
    private final CarBusinessRule rules;
    private final ModelMapper modelMapper;

    Car requestToEntity(CarRequest request){
        return modelMapper.map(request,Car.class);
    }
    CarGetResponse entityToGetResponse(Car car){
        return modelMapper.map(car,CarGetResponse.class);
    }
    CarGetAllResponse entityToGetAllResponse(Car car){
        return modelMapper.map(car,CarGetAllResponse.class);
    }


    @Override
    public void add(CarCreateRequest request) {
        Car car = requestToEntity(request);
        repository.save(car);
    }

    @Override
    public List<CarGetAllResponse> getAll() {
        return repository.findAll().stream().map(this::entityToGetAllResponse).toList();
    }

    @Override
    public CarGetResponse get(UUID id) {
        rules.checkEntityExist(id);
        return entityToGetResponse(repository.findById(id).orElseThrow());
    }

    @Override
    public void update(UUID id, CarUpdateRequest request) {
        rules.checkEntityExist(id);
        Car car = requestToEntity(request);
        car.setId(id);
        repository.save(car);
    }

    @Override
    public void delete(UUID id) {
        rules.checkEntityExist(id);
        repository.deleteById(id);
    }
}
