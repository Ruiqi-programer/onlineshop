package com.peng.sms.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Parameters for applying for an order return
 */
@Getter
@Setter
public class OmsOrderReturnApplyParam {
    @Schema(title = "Order ID")
    private Long orderId;

    @Schema(title = "Product ID to be returned")
    private Long productId;

    @Schema(title = "Order number")
    private String orderSn;

    @Schema(title = "Member username")
    private String memberUsername;

    @Schema(title = "Returnee name")
    private String returnName;

    @Schema(title = "Returnee phone number")
    private String returnPhone;

    @Schema(title = "Product image")
    private String productPic;

    @Schema(title = "Product name")
    private String productName;

    @Schema(title = "Product brand")
    private String productBrand;

    @Schema(title = "Product sale attributes, e.g., Color: Red; Size: XL;")
    private String productAttr;

    @Schema(title = "Quantity to return")
    private Integer productCount;

    @Schema(title = "Product unit price")
    private BigDecimal productPrice;

    @Schema(title = "Actual paid unit price")
    private BigDecimal productRealPrice;

    @Schema(title = "Reason for return")
    private String reason;

    @Schema(title = "Description of the issue")
    private String description;

    @Schema(title = "Proof images, separated by commas")
    private String proofPics;
}
