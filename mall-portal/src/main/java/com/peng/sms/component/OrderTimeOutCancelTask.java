package com.peng.sms.component;

import com.peng.sms.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Scheduler for cancelling overdue orders and unlocking stock
 */
//@Component
public class OrderTimeOutCancelTask {
    private Logger LOGGER = LoggerFactory.getLogger(OrderTimeOutCancelTask.class);

    @Autowired
    private OmsPortalOrderService portalOrderService;

    /**
     * Cron expression: Seconds Minutes Hours DayOfMonth Month DayOfWeek [Year]
     * Runs every 10 minutes to scan orders placed before the set timeout.
     * Cancels orders that have not been paid and releases locked stock accordingly.
     */
    @Scheduled(cron = "0 0/10 * ? * ?")
    private void cancelTimeOutOrder() {
        Integer count = portalOrderService.cancelTimeOutOrder();
        LOGGER.info("Cancelled orders and released locked stock by SKU. Number of orders cancelled: {}", count);
    }
}
