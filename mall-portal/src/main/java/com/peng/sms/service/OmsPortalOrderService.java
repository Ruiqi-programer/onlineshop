package com.peng.sms.service;

import com.peng.sms.api.CommonPage;
import com.peng.sms.domain.ConfirmOrderResult;
import com.peng.sms.domain.OmsOrderDetail;
import com.peng.sms.domain.OrderParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Frontend Order Management Service
 */
public interface OmsPortalOrderService {

    /**
     * Generate order confirmation information based on user's shopping cart
     */
    ConfirmOrderResult generateConfirmOrder(List<Long> cartIds);

    /**
     * Generate an order based on submitted information
     */
    @Transactional
    Map<String, Object> generateOrder(OrderParam orderParam);

    /**
     * Callback after successful payment
     */
    @Transactional
    Integer paySuccess(Long orderId, Integer payType);

    /**
     * Automatically cancel overdue orders
     */
    @Transactional
    Integer cancelTimeOutOrder();

    /**
     * Cancel a single overdue order
     */
    @Transactional
    void cancelOrder(Long orderId);

    /**
     * Send delayed message to cancel an order
     */
    void sendDelayMessageCancelOrder(Long orderId);

    /**
     * Confirm receipt of an order
     */
    void confirmReceiveOrder(Long orderId);

    /**
     * Get paginated list of user orders
     */
    CommonPage<OmsOrderDetail> list(Integer status, Integer pageNum, Integer pageSize);

    /**
     * Get order details by order ID
     */
    OmsOrderDetail detail(Long orderId);

    /**
     * User deletes an order by order ID
     */
    void deleteOrder(Long orderId);

    /**
     * Payment success logic based on orderSn
     */
    @Transactional
    void paySuccessByOrderSn(String orderSn, Integer payType);
}
