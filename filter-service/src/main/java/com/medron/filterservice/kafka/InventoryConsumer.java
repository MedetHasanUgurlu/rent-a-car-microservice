package com.medron.filterservice.kafka;

import com.medron.commonpackage.kafka.event.inventory.CarCreatedEvent;
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
        log.info("hiiiiiiiii");
    }
}
