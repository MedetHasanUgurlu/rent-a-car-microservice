package com.medron.paymentservice.business.dto.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentGetResponse {
    private UUID id;
    private String cardNumber;
    private String cardHolder;
    private int cardExpirationYear;
    private int cardExpirationMonth;
    private String cardCvv;
    private double balance;
}
