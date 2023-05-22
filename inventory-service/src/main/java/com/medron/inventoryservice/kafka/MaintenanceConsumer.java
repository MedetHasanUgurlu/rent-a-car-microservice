package com.medron.inventoryservice.kafka;

import com.medron.commonpackage.kafka.event.maintenance.MaintenanceCreatedEvent;
import com.medron.commonpackage.kafka.event.maintenance.MaintenanceDeletedEvent;
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
public class MaintenanceConsumer {
    private final CarService service;
    @KafkaListener(topics = "topic-maintenance-return",groupId = "gpId-maintenance-return")
    public void consume(MaintenanceReturnedEvent event){
        service.changeStatus(event.getCarId(), State.Available);
        log.info("<===== MAINTENANCE-RETURNED =====>");
        log.info("MAINTENANCE-INFO: "+event);
    }
    @KafkaListener(topics = "topic-maintenance-create",groupId = "gpId-maintenance-create")
    public void consume(MaintenanceCreatedEvent event){
        service.changeStatus(event.getCarId(), State.Maintenance);
        log.info("<===== MAINTENANCE-CREATED =====>");
        log.info("MAINTENANCE-INFO: "+event);
    }
    @KafkaListener(topics = "topic-maintenance-delete",groupId = "gpId-maintenance-delete")
    public void consume(MaintenanceDeletedEvent event){
        service.changeStatus(event.getCarId(), State.Available);
        log.info("<===== MAINTENANCE-DELETED =====>");
        log.info("MAINTENANCE-INFO: "+event);
    }
    @KafkaListener(topics = "topic-maintenance-complete",groupId = "gpId-maintenance-complete")
    public void consume(MaintenanceUpdatedEvent event){
        service.changeStatus(event.getCarId(), State.Available);
        log.info("<===== MAINTENANCE-COMPLETE =====>");
        log.info("MAINTENANCE-INFO: "+event);
    }

    /*
        topic-maintenance-create
        topic-maintenance-delete
        topic-maintenance-return
        topic-maintenance-complete
     */

}
