package com.medron.commonpackage.constant;

public class ValidationConstant {

    public class Brand{
        private Brand(){
        }
        public static final String BRAND_NAME_NOT_NULL = "BRAND_NAME_NOT_NULL";
        public static final String BRAND_NAME_NOT_EMPTY = "BRAND_NAME_NOT_EMPTY";


    }
    public class Model{
        private Model(){
        }
        public static final String MODEL_NAME_NOT_BLANK = "MODEL_NAME_NOT_BLANK";

        public static final String BRAND_ID_NOT_NULL = "BRAND_ID_NOT_NULL";
    }

    public class Car{
        private Car(){
        }
        public static final String BRAND_NAME_NOT_BLANK = "BRAND_NAME_NOT_BLANK";

    }
    public class Payment{
        private Payment(){
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
}
