package com.peng.sms.domain;


import com.peng.sms.model.OmsOrder;
import com.peng.sms.model.OmsOrderItem;

import java.util.List;

/**
 * Order Details with Items
 */
public class OmsOrderDetail extends OmsOrder {
    private List<OmsOrderItem> orderItemList;

    public List<OmsOrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OmsOrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
