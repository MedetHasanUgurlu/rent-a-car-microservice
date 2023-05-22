package com.medron.paymentservice.business.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCreateRequest implements PaymentRequest {
    private String cardNumber;
    private String cardHolder;
    private int cardExpirationYear;
    private int cardExpirationMonth;
    private String cardCvv;
    private double balance;
}
