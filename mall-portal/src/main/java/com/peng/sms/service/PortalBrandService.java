package com.peng.sms.service;

import com.peng.sms.api.CommonPage;
import com.peng.sms.model.PmsBrand;
import com.peng.sms.model.PmsProduct;

import java.util.List;

/**
 * Frontend Brand Management Service
 */
public interface PortalBrandService {

    /**
     * Get recommended brands with pagination
     *
     * @param pageNum  page number
     * @param pageSize page size
     * @return list of recommended brands
     */
    List<PmsBrand> recommendList(Integer pageNum, Integer pageSize);

    /**
     * Get brand details
     *
     * @param brandId brand ID
     * @return brand information
     */
    PmsBrand detail(Long brandId);

    /**
     * Get products associated with a brand with pagination
     *
     * @param brandId  brand ID
     * @param pageNum  page number
     * @param pageSize page size
     * @return paginated list of products
     */
    CommonPage<PmsProduct> productList(Long brandId, Integer pageNum, Integer pageSize);
}
