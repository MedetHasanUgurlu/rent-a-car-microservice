package com.medron.paymentservice.business.dto.request;

import com.medron.commonpackage.utils.annotation.Card;
import com.medron.commonpackage.utils.annotation.ExpressionYear;
import com.medron.paymentservice.constant.ValidationConstant;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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

    @ExpressionYear
    @NotEmpty(message = ValidationConstant.CARD_HOLDER_NAME_MUST_NOT_BE_EMPTY)
    @NotNull(message = ValidationConstant.CARD_HOLDER_NAME_MUST_NOT_BE_NULL)
    private String cardHolder;

    @ExpressionYear
    @Max(value = 4,message = ValidationConstant.CARD_EXPRESSION_YEAR_MUST_BE_4_DIGIT )
    @Min(value = 4,message = ValidationConstant.CARD_EXPRESSION_YEAR_MUST_BE_4_DIGIT )
    private int cardExpirationYear;

    @Max(value = 12,message = ValidationConstant.CARD_EXPRESSION_MONTH_MIN_VALUE_1_MAX_VALUE_12)
    @Min(value = 1,message = ValidationConstant.CARD_EXPRESSION_MONTH_MIN_VALUE_1_MAX_VALUE_12)
    private int cardExpirationMonth;

    @NotEmpty(message = ValidationConstant.CARD_CVV_MUST_NOT_BE_EMPTY)
    @NotNull(message = ValidationConstant.CARD_CVV_MUST_NOT_BE_NULL)
    @Max(value = 3,message = ValidationConstant.CARD_CVV_MUST_BE_3_DIGIT)
    @Min(value = 3,message = ValidationConstant.CARD_CVV_MUST_BE_3_DIGIT)
    private String cardCvv;
    @Min(value = 1,message = ValidationConstant.BALANCE)
    private double balance;
}
