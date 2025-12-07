package com.peng.sms.service;

import com.peng.sms.domain.AliPayParam;

import java.util.Map;

/**
 * @description Alipay Payment Service
 * @github https://github.com/macrozheng
 */
public interface AlipayService {
    /**
     * Generate a PC payment page based on the submitted parameters
     */
    String pay(AliPayParam aliPayParam);

    /**
     * Handle Alipay asynchronous callback
     */
    String notify(Map<String, String> params);

    /**
     * Query Alipay transaction status
     *
     * @param outTradeNo Merchant order number
     * @param tradeNo    Alipay transaction number
     * @return Alipay transaction status
     */
    String query(String outTradeNo, String tradeNo);

    /**
     * Generate a mobile payment page based on the submitted parameters
     */
    String webPay(AliPayParam aliPayParam);
}
