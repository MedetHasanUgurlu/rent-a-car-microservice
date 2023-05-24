package com.medron.inventoryservice.kafka;

import com.medron.commonpackage.kafka.event.rental.RentalCreateEvent;
import com.medron.commonpackage.kafka.event.rental.RentalDeleteEvent;
import com.medron.commonpackage.kafka.event.rental.RentalReturnEvent;
import com.medron.inventoryservice.business.CarService;
import com.medron.inventoryservice.entity.enums.State;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RentalConsumer {
    private final CarService carService;

    @KafkaListener(topics = "topic-rental-create",groupId = "inventory-rental-create")
    public void consume(RentalCreateEvent event){
        carService.changeStatus(event.getCarId(), State.Rented);
    }
    @KafkaListener(topics = "topic-rental-delete",groupId = "inventory-rental-delete")
    public void consume(RentalDeleteEvent event){
        carService.changeStatus(event.getCarId(), State.Available);
    }
    @KafkaListener(topics = "topic-rental-return",groupId = "inventory-rental-return")
    public void consume(RentalReturnEvent event){
        carService.changeStatus(event.getCarId(), State.Available);
    }
}


