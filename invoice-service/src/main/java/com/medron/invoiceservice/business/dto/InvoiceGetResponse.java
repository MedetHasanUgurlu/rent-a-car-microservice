package com.medron.invoiceservice.business.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceGetResponse {
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
