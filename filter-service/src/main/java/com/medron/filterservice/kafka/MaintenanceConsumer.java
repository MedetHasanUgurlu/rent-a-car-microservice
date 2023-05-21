package com.medron.filterservice.kafka;

import com.medron.commonpackage.kafka.event.maintenance.MaintenanceCreatedEvent;
import com.medron.commonpackage.kafka.event.maintenance.MaintenanceDeletedEvent;
import com.medron.commonpackage.kafka.event.maintenance.MaintenanceReturnedEvent;
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
public class MaintenanceConsumer {
    private final FilterService service;
    @KafkaListener(topics = "topic-maintenance-create",groupId = "gpId-maintenance-create")
    public void consume(MaintenanceCreatedEvent event){
        Filter filter = service.findByCar(event.getCarId());
        filter.setState("Maintenance");
        log.info("[MAINTENANCE-CREATED] ==> CAR-ID: "+event.getCarId().toString());
        service.add(filter);

    }
    @KafkaListener(topics = "topic-maintenance-return",groupId = "gpId-maintenance-return")
    public void consume(MaintenanceReturnedEvent event){
        Filter filter = service.findByCar(event.getCarId());
        filter.setState("Available");
        service.add(filter);
        log.info("[MAINTENANCE-RETURNED] ==> CAR-ID: "+event.getCarId().toString());


    }
    @KafkaListener(topics = "topic-maintenance-delete",groupId = "gpId-maintenance-delete")
    public void consume(MaintenanceDeletedEvent event){
        Filter filter = service.findByCar(event.getCarId());
        filter.setState("Available");
        service.add(filter);
        log.info("[MAINTENANCE-DELETED] ==> CAR-ID: "+event.getCarId().toString());

    }

}
