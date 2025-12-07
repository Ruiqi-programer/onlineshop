package com.peng.sms.component;

import com.peng.sms.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Handler for processing order cancellation messages.
 */
@Component
@RabbitListener(queues = "mall.order.cancel")
public class CancelOrderReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(CancelOrderReceiver.class);

    @Autowired
    private final OmsPortalOrderService portalOrderService;

    @Autowired
    public CancelOrderReceiver(OmsPortalOrderService portalOrderService) {
        this.portalOrderService = portalOrderService;
    }

    /**
     * Handle the incoming order cancellation message.
     *
     * @param orderId the ID of the order to be cancelled
     */
    @RabbitHandler
    public void handle(Long orderId) {
        if (orderId == null || orderId <= 0) {
            LOGGER.warn("Received invalid orderId: {}", orderId);
            return;
        }
        portalOrderService.cancelOrder(orderId);
        LOGGER.info("Processed order cancellation for orderId: {}", orderId);
    }
}
