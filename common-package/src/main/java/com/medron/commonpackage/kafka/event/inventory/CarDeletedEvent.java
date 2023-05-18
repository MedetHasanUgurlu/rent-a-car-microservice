package com.medron.commonpackage.kafka.event.inventory;

import lombok.*;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CarDeletedEvent implements BaseEvent{
    private UUID carId;
}

