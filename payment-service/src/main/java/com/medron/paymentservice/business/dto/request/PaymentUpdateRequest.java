package com.medron.paymentservice.business.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentUpdateRequest implements PaymentRequest{
    private String cardHolder;
    private double balance;
}
