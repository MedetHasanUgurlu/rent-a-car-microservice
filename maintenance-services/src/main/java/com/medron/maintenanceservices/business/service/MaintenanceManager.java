package com.medron.maintenanceservices.business.service;

import com.medron.commonpackage.kafka.event.maintenance.MaintenanceCreatedEvent;
import com.medron.commonpackage.kafka.event.maintenance.MaintenanceUpdatedEvent;
import com.medron.commonpackage.kafka.producer.KafkaProducer;
import com.medron.maintenanceservices.business.dto.request.MaintenanceCreateRequest;
import com.medron.maintenanceservices.business.dto.request.MaintenanceRequest;
import com.medron.maintenanceservices.business.dto.request.MaintenanceUpdateRequest;
import com.medron.maintenanceservices.business.dto.response.MaintenanceGetAllResponse;
import com.medron.maintenanceservices.business.dto.response.MaintenanceGetResponse;
import com.medron.maintenanceservices.business.rule.MaintenanceBusinessRule;
import com.medron.maintenanceservices.entity.Maintenance;
import com.medron.maintenanceservices.repository.MaintenanceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor public class MaintenanceManager implements MaintenanceService{
    private final MaintenanceRepository repository;
    private final ModelMapper mapper;
    private final KafkaProducer producer;
    private final MaintenanceBusinessRule rules;

    Maintenance requestToEntity(MaintenanceRequest request){
        return mapper.map(request,Maintenance.class);
    }
    MaintenanceGetResponse entityToGetResponse(Maintenance maintenance){
        return mapper.map(maintenance,MaintenanceGetResponse.class);
    }
    MaintenanceGetAllResponse entityToGetAllResponse(Maintenance maintenance){
        return mapper.map(maintenance,MaintenanceGetAllResponse.class);
    }



    @Override
    public List<MaintenanceGetAllResponse> getAll() {
        return repository.findAll().stream().map(this::entityToGetAllResponse).toList();
    }

    @Override
    public MaintenanceGetResponse getById(UUID id) {
        rules.checkEntityExist(id);
        return entityToGetResponse(repository.findById(id).orElseThrow());
    }

    @Override
    public void returnCarFromMaintenance(UUID carId) {
        rules.checkCarForReturn(carId);
        Maintenance maintenance = repository.findMaintenanceByCarIdAndIsCompletedFalse(carId);
        maintenance.setCompleted(true);
        maintenance.setPaid(true);
        repository.save(maintenance);
        producer.send(new MaintenanceCreatedEvent(carId),"maintenance-returned");

    }


    @Override
    public void add(MaintenanceCreateRequest request) {
        rules.checkCarAvailableForMaintenance(request.getCarId());
        Maintenance maintenance = requestToEntity(request);
        maintenance.setCompleted(false);
        maintenance.setCompleted(false);
        maintenance.setId(UUID.randomUUID());
        repository.save(maintenance);
        producer.send(new MaintenanceCreatedEvent(request.getCarId()),"maintenance-created");

    }

    @Override
    public void update(UUID id, MaintenanceUpdateRequest request) {
        rules.checkEntityExist(id);
        Maintenance maintenance = repository.findById(id).orElseThrow();
        maintenance.setPrice(request.getPrice());
        maintenance.setPaid(request.isPaid());
        maintenance.setCompleted(request.isCompleted());
        if(request.isCompleted()){
            producer.send(new MaintenanceUpdatedEvent(maintenance.getCarId()),"maintenance-updated");
        }
        repository.save(maintenance);

    }

    @Override
    public void delete(UUID id) {
        rules.checkEntityExist(id);
        repository.deleteById(id);
    }
}
