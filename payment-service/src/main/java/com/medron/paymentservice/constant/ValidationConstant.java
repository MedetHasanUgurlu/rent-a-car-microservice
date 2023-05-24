package com.medron.paymentservice.constant;

public class ValidationConstant {
    private ValidationConstant(){

    }
    public static final String CARD_CVV_MUST_BE_3_DIGIT = "CARD_CVV_MUST_BE_3_DIGIT";
    public static final String CARD_HOLDER_NAME_MUST_NOT_BE_NULL = "CARD_HOLDER_NAME_MUST_NOT_BE_NULL";
    public static final String CARD_HOLDER_NAME_MUST_NOT_BE_EMPTY = "CARD_HOLDER_NAME_MUST_NOT_BE_EMPTY";
    public static final String CARD_EXPRESSION_YEAR_MUST_BE_4_DIGIT = "CARD_EXPRESSION_YEAR_MUST_BE_4_DIGIT";
    public static final String CARD_NUMBER_MUST_NOT_BE_EMPTY = "CARD_NUMBER_MUST_NOT_BE_EMPTY";
    public static final String CARD_NUMBER_MUST_NOT_BE_NULL = "CARD_NUMBER_MUST_NOT_BE_NULL";
    public static final String CARD_EXPRESSION_MONTH_MIN_VALUE_1_MAX_VALUE_12 = "CARD_EXPRESSION_MONTH_MIN_VALUE_1_MAX_VALUE_12";
    public static final String CARD_CVV_MUST_NOT_BE_NULL = "CARD_CVV_MUST_NOT_BE_NULL";
    public static final String CARD_CVV_MUST_NOT_BE_EMPTY = "CARD_CVV_MUST_NOT_BE_EMPTY";
    public static final String BALANCE = "BALANCE >= 1";
}
