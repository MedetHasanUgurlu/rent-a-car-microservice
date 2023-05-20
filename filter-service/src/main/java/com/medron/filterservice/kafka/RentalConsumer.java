package com.medron.filterservice.kafka;

import com.medron.commonpackage.kafka.event.inventory.CarUpdatedEvent;
import com.medron.commonpackage.kafka.event.rental.RentalCreateEvent;
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
public class RentalConsumer {
    private final FilterService service;
    @KafkaListener(topics = "topic-rental-create",groupId = "gpId-rental-create")
    public void consume(RentalCreateEvent event){
        Filter filter = service.findByCar(event.getCarId());
        filter.setState("Rented");
    }
}
