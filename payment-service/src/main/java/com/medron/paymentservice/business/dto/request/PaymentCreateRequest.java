package com.medron.paymentservice.business.dto.request;

import com.medron.commonpackage.utils.annotation.Card;
import com.medron.commonpackage.utils.annotation.ExpressionYear;
import com.medron.paymentservice.constant.ValidationConstant;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.Year;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCreateRequest implements PaymentRequest {

    @Card
    @NotEmpty(message = ValidationConstant.CARD_NUMBER_MUST_NOT_BE_EMPTY)
    @NotNull(message = ValidationConstant.CARD_NUMBER_MUST_NOT_BE_NULL)
    private String cardNumber;


    @NotEmpty(message = ValidationConstant.CARD_HOLDER_NAME_MUST_NOT_BE_EMPTY)
    @NotNull(message = ValidationConstant.CARD_HOLDER_NAME_MUST_NOT_BE_NULL)
    private String cardHolder;

    @ExpressionYear
    @Digits(integer = 4, fraction = 0,message = ValidationConstant.CARD_EXPRESSION_YEAR_MUST_BE_4_DIGIT )
    private int cardExpirationYear;

    @Max(value = 12,message = ValidationConstant.CARD_EXPRESSION_MONTH_MIN_VALUE_1_MAX_VALUE_12)
    @Min(value = 1,message = ValidationConstant.CARD_EXPRESSION_MONTH_MIN_VALUE_1_MAX_VALUE_12)
    private int cardExpirationMonth;

    @NotEmpty(message = ValidationConstant.CARD_CVV_MUST_NOT_BE_EMPTY)
    @NotNull(message = ValidationConstant.CARD_CVV_MUST_NOT_BE_NULL)
    @Size(min = 3,max = 3,message = ValidationConstant.CARD_CVV_MUST_BE_3_DIGIT)
    private String cardCvv;
    @Min(value = 1,message = ValidationConstant.BALANCE)
    private double balance;
}
