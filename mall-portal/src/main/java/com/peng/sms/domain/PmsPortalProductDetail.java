package com.peng.sms.domain;

import com.peng.sms.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Frontend Product Detail
 */
@Getter
@Setter
public class PmsPortalProductDetail {
    @Schema(title = "Product information")
    private PmsProduct product;

    @Schema(title = "Product brand")
    private PmsBrand brand;

    @Schema(title = "Product attributes and parameters")
    private List<PmsProductAttribute> productAttributeList;

    @Schema(title = "Manually entered product attribute values")
    private List<PmsProductAttributeValue> productAttributeValueList;

    @Schema(title = "Product SKU stock information")
    private List<PmsSkuStock> skuStockList;

    @Schema(title = "Product tiered pricing settings")
    private List<PmsProductLadder> productLadderList;

    @Schema(title = "Product full reduction pricing settings")
    private List<PmsProductFullReduction> productFullReductionList;

    @Schema(title = "Available coupons for the product")
    private List<SmsCoupon> couponList;
}
