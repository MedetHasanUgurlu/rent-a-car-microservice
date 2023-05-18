package com.medron.commonpackage.kafka.event.inventory;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CarCreatedEvent implements BaseEvent{
    private String id;
    private UUID carId;
    private UUID modelId;
    private UUID brandId;
    private int modelYear;
    private String plate;
    private String state;
    private double dailyPrice;
    private String modelName;
    private String brandName;

}
