package com.medron.rentalservice.business.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentalGetAllResponse implements RentalResponse{
    private UUID id;
    private UUID carId;
    private double dailyPrice;
    private double totalPrice;
    private int rentedForDays;
    private LocalDate rentedAt;
}

