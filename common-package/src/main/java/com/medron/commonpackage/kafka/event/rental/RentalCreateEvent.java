package com.medron.commonpackage.kafka.event.rental;

import com.medron.commonpackage.kafka.event.BaseEvent;
import lombok.*;

import java.util.UUID;
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RentalCreateEvent implements BaseEvent {
    private UUID carId;
}
