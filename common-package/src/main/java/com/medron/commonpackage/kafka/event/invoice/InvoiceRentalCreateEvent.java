package com.medron.commonpackage.kafka.event.invoice;

import com.medron.commonpackage.kafka.event.BaseEvent;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceRentalCreateEvent implements BaseEvent {
    private String id;
    private String cardHolder;
    private LocalDateTime dateTime;
    private UUID carId;
    private String modelName;
    private String brandName;
    private String plate;
    private int modelYear;
    private double dailyPrice;
    private int rentedForDays;
    private double price;
}
