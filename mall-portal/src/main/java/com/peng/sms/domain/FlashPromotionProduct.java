package com.peng.sms.domain;

import com.peng.sms.model.PmsProduct;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Encapsulation of flash promotion information and product
 */
@Getter
@Setter
public class FlashPromotionProduct extends PmsProduct {
    /**
     * Flash promotion price
     */
    private BigDecimal flashPromotionPrice;

    /**
     * Total quantity available in flash promotion
     */
    private Integer flashPromotionCount;

    /**
     * Limit per customer in flash promotion
     */
    private Integer flashPromotionLimit;
}
