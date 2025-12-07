package com.peng.sms.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author macrozheng
 * @description Alipay payment related configuration
 * @github <a href="https://github.com/macrozheng">...</a>
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "alipay")
public class AlipayConfig {
    /**
     * Alipay gateway URL
     */
    private String gatewayUrl;

    /**
     * Application ID
     */
    private String appId;

    /**
     * Application private key
     */
    private String appPrivateKey;

    /**
     * Alipay public key
     */
    private String alipayPublicKey;

    /**
     * Page return URL after user confirms payment
     * Example for development environment: <a href="http://localhost:8060/#/pages/money/paySuccess">...</a>
     */
    private String returnUrl;

    /**
     * Asynchronous notification callback URL for Alipay server after payment success
     * (requires public access)
     * Example for development environment: <a href="http://localhost:8085/alipay/notify">...</a>
     */
    private String notifyUrl;

    /**
     * Response format, only JSON is supported
     */
    private String format = "JSON";

    /**
     * Encoding format for requests
     */
    private String charset = "UTF-8";

    /**
     * Signature algorithm type used to generate the signature string
     */
    private String signType = "RSA2";
}
