package com.peng.sms.service;

import com.peng.sms.domain.CartPromotionItem;
import com.peng.sms.domain.SmsCouponHistoryDetail;
import com.peng.sms.model.SmsCoupon;
import com.peng.sms.model.SmsCouponHistory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User coupon management service
 */
public interface UmsMemberCouponService {

    /**
     * Member adds a coupon
     *
     * @param couponId ID of the coupon
     */
    @Transactional
    void add(Long couponId);

    /**
     * Get the coupon history list
     *
     * @param useStatus status of coupon usage
     * @return list of coupon history
     */
    List<SmsCouponHistory> listHistory(Integer useStatus);

    /**
     * Get usable coupons based on shopping cart information
     *
     * @param cartItemList list of cart promotion items
     * @param type         type of coupon
     * @return list of usable coupon details
     */
    List<SmsCouponHistoryDetail> listCart(List<CartPromotionItem> cartItemList, Integer type);

    /**
     * Get coupons related to a specific product
     *
     * @param productId ID of the product
     * @return list of coupons
     */
    List<SmsCoupon> listByProduct(Long productId);

    /**
     * Get user's coupon list
     *
     * @param useStatus status of coupon usage
     * @return list of coupons
     */
    List<SmsCoupon> list(Integer useStatus);
}
