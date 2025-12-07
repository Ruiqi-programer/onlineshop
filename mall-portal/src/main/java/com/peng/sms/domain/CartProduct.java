package com.peng.sms.domain;

import com.peng.sms.model.PmsProduct;
import com.peng.sms.model.PmsProductAttribute;
import com.peng.sms.model.PmsSkuStock;

import java.util.List;

/**
 * Product information in the shopping cart with selected specifications
 */
public class CartProduct extends PmsProduct {
    /**
     * List of product attributes
     */
    private List<PmsProductAttribute> productAttributeList;
    /**
     * List of SKU stock items
     */
    private List<PmsSkuStock> skuStockList;

    public List<PmsProductAttribute> getProductAttributeList() {
        return productAttributeList;
    }

    public void setProductAttributeList(List<PmsProductAttribute> productAttributeList) {
        this.productAttributeList = productAttributeList;
    }

    public List<PmsSkuStock> getSkuStockList() {
        return skuStockList;
    }

    public void setSkuStockList(List<PmsSkuStock> skuStockList) {
        this.skuStockList = skuStockList;
    }
}
