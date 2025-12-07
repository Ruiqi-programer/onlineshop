package com.peng.sms.domain;

import com.peng.sms.model.CmsSubject;
import com.peng.sms.model.PmsBrand;
import com.peng.sms.model.PmsProduct;
import com.peng.sms.model.SmsHomeAdvertise;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Encapsulates the home page content response
 */
@Getter
@Setter
public class HomeContentResult {
    // Carousel advertisements
    private List<SmsHomeAdvertise> advertiseList;

    // Recommended brands
    private List<PmsBrand> brandList;

    // Current flash sale session
    private HomeFlashPromotion homeFlashPromotion;

    // New product recommendations
    private List<PmsProduct> newProductList;

    // Popular product recommendations
    private List<PmsProduct> hotProductList;

    // Recommended subjects
    private List<CmsSubject> subjectList;
}
