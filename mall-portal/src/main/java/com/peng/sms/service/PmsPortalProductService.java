package com.peng.sms.service;

import com.peng.sms.domain.PmsPortalProductDetail;
import com.peng.sms.domain.PmsProductCategoryNode;
import com.peng.sms.model.PmsProduct;

import java.util.List;

/**
 * Frontend Product Management Service
 */
public interface PmsPortalProductService {

    /**
     * Search products with multiple criteria
     *
     * @param keyword           keyword for search
     * @param brandId           brand ID filter
     * @param productCategoryId product category ID filter
     * @param pageNum           page number
     * @param pageSize          page size
     * @param sort              sorting method
     * @return list of products matching the criteria
     */
    List<PmsProduct> search(String keyword, Long brandId, Long productCategoryId, Integer pageNum, Integer pageSize, Integer sort);

    /**
     * Get all product categories in a tree structure
     *
     * @return list of product category nodes
     */
    List<PmsProductCategoryNode> categoryTreeList();

    /**
     * Get product details for frontend display
     *
     * @param id product ID
     * @return product details
     */
    PmsPortalProductDetail detail(Long id);
}
