package com.medron.filterservice.kafka;

import com.medron.commonpackage.kafka.event.maintenance.MaintenanceCreatedEvent;
import com.medron.commonpackage.kafka.event.maintenance.MaintenanceDeletedEvent;
import com.medron.commonpackage.kafka.event.maintenance.MaintenanceReturnedEvent;
import com.medron.commonpackage.kafka.event.maintenance.MaintenanceUpdatedEvent;
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
    @KafkaListener(topics = "maintenance-create",groupId = "gpId-maintenance-create")
    public void consume(MaintenanceCreatedEvent event){
        Filter filter = service.findByCar(event.getCarId());
        filter.setState("Maintenance");
        service.add(filter);
        log.info("<===== MAINTENANCE-CREATED =====>");
        log.info("MAINTENANCE-INFO: "+event);


    }
    @KafkaListener(topics = "topic-maintenance-return",groupId = "gpId-maintenance-return")
    public void consume(MaintenanceReturnedEvent event){
        Filter filter = service.findByCar(event.getCarId());
        filter.setState("Available");
        service.add(filter);
        log.info("<===== MAINTENANCE-RETURNED =====>");
        log.info("MAINTENANCE-INFO: "+event);


    }
    @KafkaListener(topics = "topic-maintenance-delete",groupId = "gpId-maintenance-delete")
    public void consume(MaintenanceDeletedEvent event){
        Filter filter = service.findByCar(event.getCarId());
        filter.setState("Available");
        service.add(filter);
        log.info("<===== MAINTENANCE-DELETED =====>");
        log.info("MAINTENANCE-INFO: "+event);

    }
    @KafkaListener(topics = "topic-maintenance-complete",groupId = "gpId-maintenance-complete")
    public void consume(MaintenanceUpdatedEvent event){
        Filter filter = service.findByCar(event.getCarId());
        filter.setState("Available");
        service.add(filter);
        log.info("<===== MAINTENANCE-COMPLETED =====>");
        log.info("MAINTENANCE-INFO: "+event);

    }

        /*
        topic-maintenance-create
        topic-maintenance-delete
        topic-maintenance-return
        topic-maintenance-complete
     */

}
