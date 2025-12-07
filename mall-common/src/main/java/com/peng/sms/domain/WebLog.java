package com.peng.sms.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Log wrapper class for Controller layer
 * Created by macro on 2018/4/26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WebLog {

    /**
     * Description of the operation
     */
    private String description;

    /**
     * Username of the operator
     */
    private String username;

    /**
     * Start time of the operation
     */
    private Long startTime;

    /**
     * Time spent on the operation (ms)
     */
    private Integer spendTime;

    /**
     * Base path of the request
     */
    private String basePath;

    /**
     * Request URI
     */
    private String uri;

    /**
     * Request URL
     */
    private String url;

    /**
     * HTTP method type (GET, POST, etc.)
     */
    private String method;

    /**
     * IP address of the client
     */
    private String ip;

    /**
     * Request parameters
     */
    private Object parameter;

    /**
     * Response result
     */
    private Object result;

}
