package com.peng.sms.domain;

import com.peng.sms.model.PmsProduct;
import com.peng.sms.model.PmsProductFullReduction;
import com.peng.sms.model.PmsProductLadder;
import com.peng.sms.model.PmsSkuStock;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Product promotion information, including SKU, discount, and full reduction
 */
@Setter
@Getter
public class PromotionProduct extends PmsProduct {
    // Product SKU stock information
    private List<PmsSkuStock> skuStockList;
    // Product discount information
    private List<PmsProductLadder> productLadderList;
    // Product full reduction information
    private List<PmsProductFullReduction> productFullReductionList;

}
