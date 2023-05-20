package com.medron.inventoryservice.business.impl;

import com.medron.commonpackage.exception.exceptions.BusinessException;
import com.medron.commonpackage.kafka.event.inventory.CarCreatedEvent;
import com.medron.commonpackage.kafka.event.inventory.CarDeletedEvent;
import com.medron.commonpackage.kafka.event.inventory.CarUpdatedEvent;
import com.medron.commonpackage.utils.dto.ClientResponse;
import com.medron.inventoryservice.business.CarService;
import com.medron.inventoryservice.business.dto.abstracts.CarRequest;
import com.medron.inventoryservice.business.dto.request.create.CarCreateRequest;
import com.medron.inventoryservice.business.dto.request.update.CarUpdateRequest;
import com.medron.inventoryservice.business.dto.response.get.CarGetResponse;
import com.medron.inventoryservice.business.dto.response.getall.CarGetAllResponse;
import com.medron.inventoryservice.kafka.InventoryProducer;
import com.medron.inventoryservice.business.rule.CarBusinessRule;
import com.medron.inventoryservice.entity.Car;
import com.medron.inventoryservice.entity.enums.State;
import com.medron.inventoryservice.repository.CarRepository;
import io.github.resilience4j.retry.annotation.Retry;
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
    private final InventoryProducer producer;

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

        rules.checkPlateExist(request.getPlate());
        Car car = requestToEntity(request);
        car.setId(UUID.randomUUID());
        car.setState(State.Available);
        Car carCreated = repository.save(car);
        sendKafkaCarCreated(carCreated);
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
        sendKafkaCarDeleted(id);
    }


    @Override
    public ClientResponse checkCarAvailable(UUID id) {
        ClientResponse response = new ClientResponse();
        try {
            rules.checkCarAvailable(id);
            response.setSuccess(true);

        }catch (BusinessException e){
            response.setMessage(e.getMessage());
            response.setSuccess(false);
        }
        return response;
    }

    public void sendKafkaCarCreated(Car car){
        CarCreatedEvent event = modelMapper.map(car,CarCreatedEvent.class);
        event.setId(UUID.randomUUID().toString());
        event.setBrandName(car.getModel().getBrand().getName());
        event.setBrandId(car.getModel().getBrand().getId());
        event.setModelYear(car.getModelYear());
        event.setDailyPrice(car.getDailyPrice());
        producer.sendMessage(event);
    }
    public void sendKafkaCarDeleted(UUID carId){
        producer.sendMessage(new CarDeletedEvent(carId));
    }

    public void sendKafkaCarUpdated(Car car){
        CarUpdatedEvent event = modelMapper.map(car,CarUpdatedEvent.class);
        producer.sendMessage(event,"topic-car-create");

    }
}
