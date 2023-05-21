package com.medron.inventoryservice.kafka;

import com.medron.commonpackage.kafka.event.maintenance.MaintenanceCreatedEvent;
import com.medron.commonpackage.kafka.event.maintenance.MaintenanceReturnedEvent;
import com.medron.commonpackage.kafka.event.maintenance.MaintenanceUpdatedEvent;
import com.medron.inventoryservice.business.CarService;
import com.medron.inventoryservice.entity.enums.State;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MaintenancesConsumer {
    private final CarService service;
    @KafkaListener(topics = "maintenance-created",groupId = "maintenance-create")
    public void consume(MaintenanceCreatedEvent event){
        service.changeStatus(event.getCarId(), State.Maintenance);
        log.info("Maintenance created event consumed {}", event);
    }
    @KafkaListener(topics = "maintenance-returned",groupId = "maintenance-return")
    public void consume(MaintenanceReturnedEvent event){
        service.changeStatus(event.getCarId(), State.Available);
        log.info("Maintenance returned event consumed {}", event);
    }
    @KafkaListener(topics = "maintenance-updated",groupId = "maintenance-update")
    public void consume(MaintenanceUpdatedEvent event){
        service.changeStatus(event.getCarId(), State.Available);
        log.info("Maintenance updated event consumed {}", event);
    }
}

