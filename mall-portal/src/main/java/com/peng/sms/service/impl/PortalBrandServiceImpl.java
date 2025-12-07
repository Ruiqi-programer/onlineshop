package com.peng.sms.service.impl;

import com.github.pagehelper.PageHelper;
import com.peng.sms.api.CommonPage;
import com.peng.sms.dao.HomeDao;
import com.peng.sms.mapper.PmsBrandMapper;
import com.peng.sms.mapper.PmsProductMapper;
import com.peng.sms.model.PmsBrand;
import com.peng.sms.model.PmsProduct;
import com.peng.sms.model.PmsProductExample;
import com.peng.sms.service.PortalBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Frontend Brand Management Service Implementation
 */
@Service
public class PortalBrandServiceImpl implements PortalBrandService {
    @Autowired
    private HomeDao homeDao;
    @Autowired
    private PmsBrandMapper brandMapper;
    @Autowired
    private PmsProductMapper productMapper;

    /**
     * Get a paginated list of recommended brands
     */
    @Override
    public List<PmsBrand> recommendList(Integer pageNum, Integer pageSize) {
        int offset = (pageNum - 1) * pageSize;
        return homeDao.getRecommendedBrands(offset, pageSize);
    }

    /**
     * Get brand details by ID
     */
    @Override
    public PmsBrand detail(Long brandId) {
        return brandMapper.selectByPrimaryKey(brandId);
    }

    /**
     * Get a paginated list of products under a brand
     */
    @Override
    public CommonPage<PmsProduct> productList(Long brandId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProductExample example = new PmsProductExample();
        example.createCriteria()
                .andDeleteStatusEqualTo(0)  // Only include products that are not deleted
                .andBrandIdEqualTo(brandId); // Filter by brand ID
        List<PmsProduct> productList = productMapper.selectByExample(example);
        return CommonPage.restPage(productList);
    }
}
