package com.peng.sms.dao;

import com.peng.sms.domain.FlashPromotionProduct;
import com.peng.sms.model.CmsSubject;
import com.peng.sms.model.PmsBrand;
import com.peng.sms.model.PmsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Custom DAO for Home Content Management
 */
public interface HomeDao {

    /**
     * Get recommended brands
     */
    List<PmsBrand> getRecommendedBrands(@Param("offset") Integer offset, @Param("limit") Integer limit);
    /**
     * Get flash sale products
     */
    List<FlashPromotionProduct> getFlashPromotionProducts(@Param("flashPromotionId") Long flashPromotionId, @Param("sessionId") Long sessionId);

    /**
     * Get new products
     */
    List<PmsProduct> getNewProducts(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * Get hot products
     */
    List<PmsProduct> getHotProducts(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * Get recommended subjects
     */
    List<CmsSubject> getRecommendedSubjects(@Param("offset") Integer offset, @Param("limit") Integer limit);
}
