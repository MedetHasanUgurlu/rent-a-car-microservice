package com.medron.inventoryservice.kafka;

import com.medron.commonpackage.kafka.CarCreatedEvent;
import com.medron.inventoryservice.business.dto.abstracts.CarRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryProducer {

    private final KafkaTemplate<String,Object> kafkaTemplate;

    public void sendMessage(CarCreatedEvent carCreatedEvent){
        Message message = MessageBuilder
                .withPayload(carCreatedEvent)
                .setHeader(KafkaHeaders.TOPIC,"topic-car-create")
                .build();
        kafkaTemplate.send(message);
        log.info(String.format("Car-created event sent=> %s",carCreatedEvent));
    }


}
