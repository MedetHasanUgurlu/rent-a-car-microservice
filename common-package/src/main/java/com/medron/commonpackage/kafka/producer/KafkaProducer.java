package com.medron.commonpackage.kafka.producer;

import com.medron.commonpackage.kafka.event.BaseEvent;
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
public class KafkaProducer {
    private final KafkaTemplate<String,Object> kafkaTemplate;
    public <T extends BaseEvent> void send(T data, String topicName){
        Message<T> message = MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC,topicName).build();
        kafkaTemplate.send(message);
        log.error("[Data]: "+data.toString()+"[TopicName]: "+topicName);

    }
}
