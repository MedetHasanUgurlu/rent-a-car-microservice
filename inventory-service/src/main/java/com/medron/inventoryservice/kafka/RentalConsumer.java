package com.medron.inventoryservice.kafka;

import com.medron.commonpackage.kafka.event.rental.RentalCreateEvent;
import com.medron.inventoryservice.business.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RentalConsumer {
    private final KafkaTemplate<String,Object> kafkaTemplate;
    private final CarService carService;

    @KafkaListener(topics = "topic-rental-create",groupId = "gp-rental-create")
    public void consume(RentalCreateEvent event){

    }
}
