package com.medron.rentalservice.business.dto.request;

import com.medron.commonpackage.utils.dto.PaymentRentalRequest;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentalCreateRequest implements RentalRequest{

    private UUID carId;
    private double dailyPrice;
    private int rentedForDays;
    private PaymentRentalRequest paymentRentalRequest;
}
