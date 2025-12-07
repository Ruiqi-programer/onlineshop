package com.peng.sms.service;

import com.peng.sms.domain.CartProduct;
import com.peng.sms.domain.CartPromotionItem;
import com.peng.sms.model.OmsCartItem;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Shopping Cart Management Service
 */
public interface OmsCartItemService {

    /**
     * Add an item to the cart.
     * If the cart already contains the item, increase the quantity; otherwise, add the item.
     */
    @Transactional
    int add(OmsCartItem cartItem);

    /**
     * Get the list of cart items by member ID.
     */
    List<OmsCartItem> list(Long memberId);

    /**
     * Get the cart items along with promotion information.
     */
    List<CartPromotionItem> listPromotion(Long memberId, List<Long> cartIds);

    /**
     * Update the quantity of a cart item.
     */
    int updateQuantity(Long id, Long memberId, Integer quantity);

    /**
     * Delete multiple items from the cart.
     */
    int delete(Long memberId, List<Long> ids);

    /**
     * Get detailed product information for items in the cart (used for selecting product specifications).
     */
    CartProduct getCartProduct(Long productId);

    /**
     * Update the specifications of a cart item.
     */
    @Transactional
    int updateAttr(OmsCartItem cartItem);

    /**
     * Clear all items from the cart.
     */
    int clear(Long memberId);
}
