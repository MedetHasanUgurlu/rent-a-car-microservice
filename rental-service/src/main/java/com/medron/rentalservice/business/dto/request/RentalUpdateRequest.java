package com.medron.rentalservice.business.dto.request;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentalUpdateRequest implements RentalRequest{
    private UUID carId;
    private double dailyPrice;
    private int rentedForDays;
}
