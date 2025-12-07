package com.peng.sms.domain;

import com.peng.sms.model.SmsCoupon;
import com.peng.sms.model.SmsCouponHistory;
import com.peng.sms.model.SmsCouponProductCategoryRelation;
import com.peng.sms.model.SmsCouponProductRelation;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Coupon redemption history details encapsulation
 */
@Setter
@Getter
public class SmsCouponHistoryDetail extends SmsCouponHistory {
    // Related coupon information
    private SmsCoupon coupon;

    // Coupon-related products
    private List<SmsCouponProductRelation> productRelationList;

    // Coupon-related product categories
    private List<SmsCouponProductCategoryRelation> categoryRelationList;

}
