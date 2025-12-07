package com.peng.sms.dao;

import com.peng.sms.domain.OmsOrderDetail;
import com.peng.sms.model.OmsOrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Custom DAO for frontend orders
 */
public interface PortalOrderDao {

    /**
     * Get order details along with ordered products
     */
    OmsOrderDetail getDetail(@Param("orderId") Long orderId);

    /**
     * Update the locked stock and actual stock in the pms_sku_stock table
     */
    int updateSkuStock(@Param("itemList") List<OmsOrderItem> orderItemList);

    /**
     * Get orders that have timed out
     *
     * @param minute timeout in minutes
     */
    List<OmsOrderDetail> getTimeOutOrders(@Param("minute") Integer minute);

    /**
     * Batch update order status
     */
    int updateOrderStatus(@Param("ids") List<Long> ids, @Param("status") Integer status);

    /**
     * Release the locked stock of cancelled orders
     */
    int releaseSkuStockLock(@Param("itemList") List<OmsOrderItem> orderItemList);
}
