package com.peng.sms.domain;

import com.peng.sms.model.UmsIntegrationConsumeSetting;
import com.peng.sms.model.UmsMemberReceiveAddress;

import java.math.BigDecimal;
import java.util.List;

/**
 * Encapsulation of order confirmation information
 */
public class ConfirmOrderResult {
    /**
     * Shopping cart information including promotion details
     */
    private List<CartPromotionItem> cartPromotionItemList;

    /**
     * User's shipping address list
     */
    private List<UmsMemberReceiveAddress> memberReceiveAddressList;

    /**
     * User's available coupon list
     */
    private List<SmsCouponHistoryDetail> couponHistoryDetailList;

    /**
     * Rules for using points
     */
    private UmsIntegrationConsumeSetting integrationConsumeSetting;

    /**
     * Member's available points
     */
    private Integer memberIntegration;

    /**
     * Calculated amounts
     */
    private CalcAmount calcAmount;

    public List<CartPromotionItem> getCartPromotionItemList() {
        return cartPromotionItemList;
    }

    public void setCartPromotionItemList(List<CartPromotionItem> cartPromotionItemList) {
        this.cartPromotionItemList = cartPromotionItemList;
    }

    public List<UmsMemberReceiveAddress> getMemberReceiveAddressList() {
        return memberReceiveAddressList;
    }

    public void setMemberReceiveAddressList(List<UmsMemberReceiveAddress> memberReceiveAddressList) {
        this.memberReceiveAddressList = memberReceiveAddressList;
    }

    public List<SmsCouponHistoryDetail> getCouponHistoryDetailList() {
        return couponHistoryDetailList;
    }

    public void setCouponHistoryDetailList(List<SmsCouponHistoryDetail> couponHistoryDetailList) {
        this.couponHistoryDetailList = couponHistoryDetailList;
    }

    public UmsIntegrationConsumeSetting getIntegrationConsumeSetting() {
        return integrationConsumeSetting;
    }

    public void setIntegrationConsumeSetting(UmsIntegrationConsumeSetting integrationConsumeSetting) {
        this.integrationConsumeSetting = integrationConsumeSetting;
    }

    public Integer getMemberIntegration() {
        return memberIntegration;
    }

    public void setMemberIntegration(Integer memberIntegration) {
        this.memberIntegration = memberIntegration;
    }

    public CalcAmount getCalcAmount() {
        return calcAmount;
    }

    public void setCalcAmount(CalcAmount calcAmount) {
        this.calcAmount = calcAmount;
    }

    /**
     * Inner class representing calculated amounts
     */
    public static class CalcAmount {
        /**
         * Total amount of order items
         */
        private BigDecimal totalAmount;

        /**
         * Shipping fee
         */
        private BigDecimal freightAmount;

        /**
         * Promotion discount
         */
        private BigDecimal promotionAmount;

        /**
         * Amount payable
         */
        private BigDecimal payAmount;

        public BigDecimal getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(BigDecimal totalAmount) {
            this.totalAmount = totalAmount;
        }

        public BigDecimal getFreightAmount() {
            return freightAmount;
        }

        public void setFreightAmount(BigDecimal freightAmount) {
            this.freightAmount = freightAmount;
        }

        public BigDecimal getPromotionAmount() {
            return promotionAmount;
        }

        public void setPromotionAmount(BigDecimal promotionAmount) {
            this.promotionAmount = promotionAmount;
        }

        public BigDecimal getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(BigDecimal payAmount) {
            this.payAmount = payAmount;
        }
    }
}
