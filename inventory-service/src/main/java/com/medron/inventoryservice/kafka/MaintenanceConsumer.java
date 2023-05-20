package com.medron.inventoryservice.kafka;

import com.medron.commonpackage.kafka.event.maintenance.MaintenanceCreatedEvent;
import com.medron.commonpackage.kafka.event.maintenance.MaintenanceDeletedEvent;
import com.medron.commonpackage.kafka.event.maintenance.MaintenanceReturnedEvent;
import com.medron.inventoryservice.business.CarService;
import com.medron.inventoryservice.entity.enums.State;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MaintenanceConsumer {
    private final CarService service;

    @KafkaListener(topics = "topic-maintenance-return",groupId = "gpId-maintenance-return")
    public void consume(MaintenanceReturnedEvent event){
        service.changeStatus(event.getCarId(), State.Available);
    }
    @KafkaListener(topics = "topic-maintenance-create",groupId = "gpId-maintenance-create")
    public void consume(MaintenanceCreatedEvent event){
        service.changeStatus(event.getCarId(), State.Maintenance);
    }
    @KafkaListener(topics = "topic-maintenance-delete",groupId = "gpId-maintenance-delete")
    public void consume(MaintenanceDeletedEvent event){
        service.changeStatus(event.getCarId(), State.Available);
    }
}
