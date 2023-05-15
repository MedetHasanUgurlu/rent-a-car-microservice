package com.medron.inventoryservice.kafka;

import com.medron.commonpackage.kafka.event.inventory.CarCreatedEvent;
import com.medron.commonpackage.kafka.event.inventory.CarDeletedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
        Message message = MessageBuilder.withPayload(carCreatedEvent).setHeader(KafkaHeaders.TOPIC,"topic-car-create").build();
        kafkaTemplate.send(message);
        log.info(String.format("Car-created event sent=> %s",carCreatedEvent));
    }
    public void sendMessage(CarDeletedEvent event){
        Message message = MessageBuilder.withPayload(event).setHeader(KafkaHeaders.TOPIC,"topic-car-delete").build();
        kafkaTemplate.send(message);
        log.info(String.format("[car-deleted-event]:%s",event.getCarId().toString()));
    }

    public void sendMessage(Object o,String topicName){
        Message<Object> message = MessageBuilder.withPayload(o).setHeader(KafkaHeaders.TOPIC,topicName).build();
        kafkaTemplate.send(message);
    }


}
