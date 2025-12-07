package com.peng.sms.domain;

import com.peng.sms.model.OmsCartItem;
import java.math.BigDecimal;

/**
 * Encapsulation of promotion information in the shopping cart
 */
public class CartPromotionItem extends OmsCartItem {
    /**
     * Promotion activity information
     */
    private String promotionMessage;

    /**
     * Amount reduced by promotion for each product
     */
    private BigDecimal reduceAmount;

    /**
     * Actual stock of the product (remaining stock - locked stock)
     */
    private Integer realStock;

    /**
     * Reward points given for purchasing the product
     */
    private Integer integration;

    /**
     * Growth value given for purchasing the product
     */
    private Integer growth;

    public String getPromotionMessage() {
        return promotionMessage;
    }

    public void setPromotionMessage(String promotionMessage) {
        this.promotionMessage = promotionMessage;
    }

    public BigDecimal getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(BigDecimal reduceAmount) {
        this.reduceAmount = reduceAmount;
    }

    public Integer getRealStock() {
        return realStock;
    }

    public void setRealStock(Integer realStock) {
        this.realStock = realStock;
    }

    public Integer getIntegration() {
        return integration;
    }

    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }
}
