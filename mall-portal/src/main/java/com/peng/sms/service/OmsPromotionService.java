package com.peng.sms.service;

import com.peng.sms.domain.CartPromotionItem;
import com.peng.sms.model.OmsCartItem;

import java.util.List;

/**
 * Promotion Management Service
 */
public interface OmsPromotionService {

    /**
     * Calculate promotion information for items in the shopping cart
     *
     * @param cartItemList the shopping cart items
     * @return list of cart items with promotion details
     */
    List<CartPromotionItem> calcCartPromotion(List<OmsCartItem> cartItemList);
}
