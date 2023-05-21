package com.medron.filterservice.kafka;

import com.medron.commonpackage.kafka.event.maintenance.MaintenanceCreatedEvent;
import com.medron.commonpackage.kafka.event.maintenance.MaintenanceReturnedEvent;
import com.medron.commonpackage.kafka.event.maintenance.MaintenanceUpdatedEvent;
import com.medron.commonpackage.kafka.event.rental.RentalCreateEvent;
import com.medron.filterservice.business.FilterService;
import com.medron.filterservice.entity.Filter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MaintenancesConsumer {
    private final FilterService service;
    @KafkaListener(topics = "maintenance-created",groupId = "maintenance-create")
    public void consume(MaintenanceCreatedEvent event){
        var filter = service.findByCar(event.getCarId());
        filter.setState("Maintenance");
        service.add(filter);
        log.info("Maintenance created event consumed {}", event);
    }
    @KafkaListener(topics = "maintenance-returned",groupId = "maintenance-return")
    public void consume(MaintenanceReturnedEvent event){
        var filter = service.findByCar(event.getCarId());
        filter.setState("Available");
        service.add(filter);
        log.info("Maintenance returned event consumed {}", event);
    }
    @KafkaListener(topics = "maintenance-updated",groupId = "maintenance-update")
    public void consume(MaintenanceUpdatedEvent event){
        var filter = service.findByCar(event.getCarId());
        filter.setState("Available");
        service.add(filter);
        log.info("Maintenance updated event consumed {}", event);
    }
}

//
//    maintenance-returned
//            maintenance-created
//            maintenance-updated