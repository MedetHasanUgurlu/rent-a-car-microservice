package com.medron.commonpackage.kafka.event.inventory;


import lombok.*;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CarUpdatedEvent implements BaseEvent{

    private UUID carId;
    private UUID modelId;
    private String plate;
    private String state;
    private int modelYear;


}
