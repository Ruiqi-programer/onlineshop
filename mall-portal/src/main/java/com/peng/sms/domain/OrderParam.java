package com.peng.sms.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Parameters passed when creating an order
 * Created by macro on 2018/8/30.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderParam {
    @Schema(title = "ID of the shipping address")
    private Long memberReceiveAddressId;

    @Schema(title = "Coupon ID")
    private Long couponId;

    @Schema(title = "Number of points to use")
    private Integer useIntegration;

    @Schema(title = "Payment method")
    private Integer payType;

    @Schema(title = "IDs of selected items in the shopping cart")
    private List<Long> cartIds;
}
