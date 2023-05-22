package com.medron.maintenanceservice.business.service.imp;

import com.medron.commonpackage.kafka.event.maintenance.MaintenanceCreatedEvent;
import com.medron.commonpackage.kafka.event.maintenance.MaintenanceDeletedEvent;
import com.medron.commonpackage.kafka.event.maintenance.MaintenanceReturnedEvent;
import com.medron.commonpackage.kafka.event.maintenance.MaintenanceUpdatedEvent;
import com.medron.commonpackage.kafka.producer.KafkaProducer;
import com.medron.maintenanceservice.business.dto.request.MaintenanceCreateRequest;
import com.medron.maintenanceservice.business.dto.request.MaintenanceUpdateRequest;
import com.medron.maintenanceservice.business.dto.request.abstracts.MaintenanceRequest;
import com.medron.maintenanceservice.business.dto.response.MaintenanceGetAllResponse;
import com.medron.maintenanceservice.business.dto.response.MaintenanceGetResponse;
import com.medron.maintenanceservice.business.rule.MaintenanceBusinessRule;
import com.medron.maintenanceservice.business.service.MaintenanceService;
import com.medron.maintenanceservice.entity.Maintenance;
import com.medron.maintenanceservice.repository.MaintenanceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImp implements MaintenanceService {
    private final MaintenanceRepository repository;
    private final ModelMapper mapper;
    private final KafkaProducer producer;
    private final MaintenanceBusinessRule rule;



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
        return entityToGetResponse(repository.findById(id).orElseThrow());
    }

    @Override
    public void returnCarFromMaintenance(UUID carId) {
        rule.checkCarForReturn(carId);
        Maintenance maintenance = repository.findMaintenanceByCarIdAndIsCompletedFalse(carId);
        maintenance.setCompleted(true);
        maintenance.setPaid(true);
        maintenance.setExitDate(LocalDateTime.now());
        repository.save(maintenance);
        sendToKafkaMaintenanceReturn(carId);
       }

    @Override
    public void add(MaintenanceCreateRequest request) {
        rule.checkCarAvailableForMaintenance(request.getCarId());
        Maintenance maintenance = requestToEntity(request);
        maintenance.setEntryDate(LocalDateTime.now());
        maintenance.setCompleted(false);
        maintenance.setPaid(false);
        maintenance.setId(null);
        maintenance.setCarId(request.getCarId());
        repository.save(maintenance);
        sendToKafkaMaintenanceCreate(request.getCarId());
    }

    @Override
    public void update(UUID id, MaintenanceUpdateRequest request) {
        Maintenance maintenance = repository.findById(id).orElseThrow();
        maintenance.setComplaint(request.getComplaint());
        maintenance.setPrice(request.getPrice());
        maintenance.setPaid(request.isPaid());
        maintenance.setCompleted(request.isCompleted());
        maintenance.setId(id);
        if(request.isCompleted()){
            sendToKafkaMaintenanceIsComplete(maintenance);
        }
        repository.save(maintenance);
    }

    @Override
    public void delete(UUID id) {
        UUID carId = repository.findById(id).orElseThrow().getCarId();
        repository.deleteById(id);
        sendToKafkaMaintenanceDelete(carId);
    }
    private void sendToKafkaMaintenanceIsComplete(Maintenance maintenance){
        producer.send(new MaintenanceUpdatedEvent(maintenance.getCarId()),"topic-maintenance-complete");
    }
    private void sendToKafkaMaintenanceDelete(UUID carId){
        producer.send(new MaintenanceDeletedEvent(carId),"topic-maintenance-delete");

    }
    private void sendToKafkaMaintenanceCreate(UUID carId){
        producer.send(new MaintenanceCreatedEvent(carId),"maintenance-create");

    }
    private void sendToKafkaMaintenanceReturn(UUID carId){
        producer.send(new MaintenanceReturnedEvent(carId),"topic-maintenance-return");
    }


    /*
        topic-maintenance-create
        topic-maintenance-delete
        topic-maintenance-return
        topic-maintenance-complete
     */


}
