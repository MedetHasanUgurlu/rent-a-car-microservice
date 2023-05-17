package com.medron.filterservice.kafka;

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
        Filter filter = mapper.map(event,Filter.class);
        service.add(mapper.map(event,Filter.class));
        log.info("Car created."+event.toString());
    }

    @KafkaListener(topics = "topic-car-delete",groupId = "gpId-car-delete")
    public void consume(CarDeletedEvent event){
        service.deleteCar(event.getCarId());
        log.info("Car deleted."+"[CAR_ID]:"+event.getCarId());
    }
    @KafkaListener(topics = "topic-car-update",groupId = "gpId-car-update")
    public void consume(CarUpdatedEvent event){
        Filter filter = service.findByCar(event.getCarId());
        filter.setCarId(event.getCarId());
        filter.setState(event.getState());
        filter.setModelYear(event.getModelYear());
        filter.setPlate(event.getPlate());
        filter.setModelId(event.getModelId());
        service.add(filter);
    }
    @KafkaListener(topics ="topic-model-delete",groupId = "gpId-model-delete")
    public void consume(ModelDeletedEvent event){
        service.deleteAllModel(event.getModelId());
    }
    @KafkaListener(topics ="topic-brand-delete",groupId = "gpId-brand-delete")
    public void consume(BrandDeletedEvent event){
        service.deleteAllModel(event.getBrandId());
    }


}
