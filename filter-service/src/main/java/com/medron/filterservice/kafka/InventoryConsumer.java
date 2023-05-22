package com.medron.filterservice.kafka;

import com.medron.commonpackage.kafka.event.BaseEvent;
import com.medron.commonpackage.kafka.event.inventory.*;
import com.medron.filterservice.business.FilterService;
import com.medron.filterservice.entity.Filter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryConsumer {
    private final FilterService service;
    private final ModelMapper mapper;


    @KafkaListener(topics = "topic-car-create",groupId = "gpId-car-create")
    public void consume(CarCreatedEvent event){
        service.add(mapper.map(event,Filter.class));
        log.info("<===== CAR-CREATED =====>");
        log.info("CAR-INFO: "+event.toString());
    }
    @KafkaListener(topics = "topic-car-state-change",groupId = "gpId-car-state-change")
    public void consume(StateChangeEvent event){
        Filter filter = service.findByCar(event.getId());
        filter.setState(event.getState());
        service.add(filter);
        log.info("<===== CAR-STATE-CHANGED =====>");
        log.info("CAR-INFO: "+event);
    }
    @KafkaListener(topics = "topic-car-delete",groupId = "gpId-car-delete")
    public void consume(CarDeletedEvent event){
        service.deleteCar(event.getCarId());
        log.info("<===== CAR-DELETED =====>");
        log.info("CAR-INFO: "+event);
    }

    @KafkaListener(topics = "topic-car-update",groupId = "gpId-car-update")
    public void consume(CarUpdatedEvent event){
        Filter filter = service.findByCar(event.getCarId());
        filter.setState(event.getState());
        filter.setModelYear(event.getModelYear());
        filter.setPlate(event.getPlate());
        filter.setModelId(event.getModelId());
        service.add(filter);
        log.info("<===== CAR-UPDATED =====>");
        log.info("CAR-INFO: "+event);
    }
    @KafkaListener(topics ="topic-model-delete",groupId = "gpId-model-delete")
    public void consume(ModelDeletedEvent event){
        service.deleteAllModel(event.getModelId());
        log.info("<===== MODEL-DELETED =====>");
        log.info("MODEL-INFO: "+event);
    }
    @KafkaListener(topics ="topic-brand-delete",groupId = "gpId-brand-delete")
    public void consume(BrandDeletedEvent event){
        service.deleteAllBrand(event.getBrandId());
        log.info("<===== BRAND-DELETED =====>");
        log.info("BRAND-INFO: "+event);
    }






}
