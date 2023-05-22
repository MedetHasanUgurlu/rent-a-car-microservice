package com.medron.commonpackage.kafka.event.inventory;

import com.medron.commonpackage.kafka.event.BaseEvent;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StateChangeEvent implements BaseEvent {
    private UUID id;
    private String state;
}
