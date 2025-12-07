package com.peng.sms.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author macrozheng
 * @description Alipay payment request parameters
 * @github https://github.com/macrozheng
 */
@Data
public class AliPayParam {
    /**
     * Merchant order number, custom defined by the merchant, must be unique
     */
    private String outTradeNo;

    /**
     * Product title / transaction title / order title / order keyword, etc.
     */
    private String subject;

    /**
     * Total order amount, in yuan, precise to two decimal places
     */
    private BigDecimal totalAmount;
}
