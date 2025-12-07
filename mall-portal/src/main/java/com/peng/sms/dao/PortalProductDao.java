package com.peng.sms.dao;

import com.peng.sms.domain.CartProduct;
import com.peng.sms.domain.PromotionProduct;
import com.peng.sms.model.SmsCoupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Custom DAO for frontend system products
 */
public interface PortalProductDao {

    /**
     * Get product information for the shopping cart
     */
    CartProduct getCartProduct(@Param("id") Long id);

    /**
     * Get a list of promotion products by their IDs
     */
    List<PromotionProduct> getPromotionProductList(@Param("ids") List<Long> ids);

    /**
     * Get a list of available coupons for a product
     *
     * @param productId         the ID of the product
     * @param productCategoryId the category ID of the product
     */
    List<SmsCoupon> getAvailableCouponList(@Param("productId") Long productId,
                                           @Param("productCategoryId") Long productCategoryId);
}
