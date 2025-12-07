package com.peng.sms.domain;

import lombok.Getter;

/**
 * Message Queue Enum Configuration
 */
@Getter
public enum QueueEnum {
    /**
     * Message notification queue
     */
    QUEUE_ORDER_CANCEL("mall.order.direct", "mall.order.cancel", "mall.order.cancel"),

    /**
     * Message notification TTL queue
     */
    QUEUE_TTL_ORDER_CANCEL("mall.order.direct.ttl", "mall.order.cancel.ttl", "mall.order.cancel.ttl");

    /**
     * Exchange name
     */
    private String exchange;

    /**
     * Queue name
     */
    private String name;

    /**
     * Routing key
     */
    private String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }
}
