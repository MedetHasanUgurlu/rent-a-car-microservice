package com.medron.filterservice.kafka;

import com.medron.commonpackage.kafka.event.inventory.CarCreatedEvent;
import com.medron.commonpackage.kafka.event.inventory.CarDeletedEvent;
import com.medron.commonpackage.utils.mapper.ModelMapperService;
import com.medron.filterservice.business.service.FilterService;
import com.medron.filterservice.entity.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InventoryConsumer {
    private final FilterService service;
    private final ModelMapperService modelMapperService;


    @KafkaListener(topics = "topic-car-create",groupId = "gpId:car-create")
    public void consume(CarCreatedEvent event){
        Filter filter = modelMapperService.forRequest().map(event,Filter.class);
        service.add(filter);
    }
    @KafkaListener(topics = "topic-car-delete",groupId = "gpId:car-delete")
    public void consume(CarDeletedEvent event){
        service.deleteCarById(event.getCarId());
    }
}
