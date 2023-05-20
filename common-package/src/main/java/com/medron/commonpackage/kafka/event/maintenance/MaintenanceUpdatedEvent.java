package com.medron.commonpackage.kafka.event.maintenance;

import com.medron.commonpackage.kafka.event.BaseEvent;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceUpdatedEvent implements BaseEvent {
    private UUID carId;
}
