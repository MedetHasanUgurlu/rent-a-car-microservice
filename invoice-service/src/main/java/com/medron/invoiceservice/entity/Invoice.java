package com.medron.invoiceservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

    @Id
    private String id;
    private String cardHolder;
    private LocalDateTime dateTime;
    private UUID carId;
    private String modelName;
    private String brandName;
    private String plate;
    private int modelYear;
    private int dailyPrice;
    private int rentedForDays;
    private double price;

}
