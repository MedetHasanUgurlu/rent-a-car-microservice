package com.medron.commonpackage.kafka.event.rental;

import com.medron.commonpackage.kafka.event.inventory.BaseEvent;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class
RentalDeleteEvent implements BaseEvent {
    private UUID carId;
}
