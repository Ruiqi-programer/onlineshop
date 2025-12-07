package com.peng.sms.service;


import com.peng.sms.domain.HomeContentResult;
import com.peng.sms.model.CmsSubject;
import com.peng.sms.model.PmsProduct;
import com.peng.sms.model.PmsProductCategory;

import java.util.List;

/**
 * Service for managing homepage content
 */
public interface HomeService {

    /**
     * Get homepage content
     */
    HomeContentResult content();

    /**
     * Get recommended products for the homepage
     */
    List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum);

    /**
     * Get product categories
     *
     * @param parentId 0: get first-level categories; others: get specified second-level categories
     */
    List<PmsProductCategory> getProductCateList(Long parentId);

    /**
     * Get subjects by category with pagination
     *
     * @param cateId category ID for the subject
     */
    List<CmsSubject> getSubjectList(Long cateId, Integer pageSize, Integer pageNum);

    /**
     * Get popular recommended products with pagination
     */
    List<PmsProduct> hotProductList(Integer pageNum, Integer pageSize);

    /**
     * Get newly recommended products with pagination
     */
    List<PmsProduct> newProductList(Integer pageNum, Integer pageSize);
}
