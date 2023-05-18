package com.medron.commonpackage.kafka.event.inventory;

import lombok.*;

import java.util.UUID;


@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ModelDeletedEvent implements BaseEvent{
    private UUID modelId;
}


