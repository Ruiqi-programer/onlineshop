package com.peng.sms.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author macrozheng
 * @description Configuration for Alipay request client
 * @github <a href="https://github.com/macrozheng">...</a>
 */
@Configuration
public class AlipayClientConfig {

    @Bean
    public AlipayClient alipayClient(AlipayConfig config){
        return new DefaultAlipayClient(
                config.getGatewayUrl(),
                config.getAppId(),
                config.getAppPrivateKey(),
                config.getFormat(),
                config.getCharset(),
                config.getAlipayPublicKey(),
                config.getSignType()
        );
    }
}
