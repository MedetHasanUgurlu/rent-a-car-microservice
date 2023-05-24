package com.medron.commonpackage.kafka.event.rental;

import com.medron.commonpackage.kafka.event.BaseEvent;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentalReturnEvent implements BaseEvent {
    private UUID carId;
}
