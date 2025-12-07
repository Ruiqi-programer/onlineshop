package com.peng.sms.dao;

import com.peng.sms.model.OmsOrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Custom DAO for order item information
 */
public interface PortalOrderItemDao {

    /**
     * Batch insert order items
     */
    void insertList(@Param("list") List<OmsOrderItem> list);
}
