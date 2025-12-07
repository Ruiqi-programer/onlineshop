package com.peng.sms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.peng.sms.config.AlipayConfig;
import com.peng.sms.domain.AliPayParam;
import com.peng.sms.mapper.OmsOrderMapper;
import com.peng.sms.service.AlipayService;
import com.peng.sms.service.OmsPortalOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author macrozheng
 * @description Alipay payment service implementation class
 */
@Slf4j
@Service
public class AlipayServiceImpl implements AlipayService {
    @Autowired
    private AlipayConfig alipayConfig;
    @Autowired
    private AlipayClient alipayClient;
    @Autowired
    private OmsOrderMapper orderMapper;
    @Autowired
    private OmsPortalOrderService portalOrderService;

    @Override
    public String pay(AliPayParam aliPayParam) {
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        if (StrUtil.isNotEmpty(alipayConfig.getNotifyUrl())) {
            // Asynchronous callback URL, accessible publicly
            request.setNotifyUrl(alipayConfig.getNotifyUrl());
        }
        if (StrUtil.isNotEmpty(alipayConfig.getReturnUrl())) {
            // Synchronous redirect URL
            request.setReturnUrl(alipayConfig.getReturnUrl());
        }
        // ******Required parameters******
        JSONObject bizContent = new JSONObject();
        // Merchant order number, unique
        bizContent.put("out_trade_no", aliPayParam.getOutTradeNo());
        // Payment amount, minimum 0.01
        bizContent.put("total_amount", aliPayParam.getTotalAmount());
        // Order title, special characters not allowed
        bizContent.put("subject", aliPayParam.getSubject());
        // Fixed value for PC website payment
        bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");
        request.setBizContent(bizContent.toString());

        String formHtml = null;
        try {
            formHtml = alipayClient.pageExecute(request).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return formHtml;
    }

    @Override
    public String notify(Map<String, String> params) {
        String result = "failure";
        boolean signVerified = false;
        try {
            // Verify the signature using SDK
            signVerified = AlipaySignature.rsaCheckV1(params, alipayConfig.getAlipayPublicKey(),
                    alipayConfig.getCharset(), alipayConfig.getSignType());
        } catch (AlipayApiException e) {
            log.error("Payment callback signature verification exception!", e);
            e.printStackTrace();
        }

        if (signVerified) {
            String tradeStatus = params.get("trade_status");
            if ("TRADE_SUCCESS".equals(tradeStatus)) {
                result = "success";
                log.info("notify method called, tradeStatus: {}", tradeStatus);
                String outTradeNo = params.get("out_trade_no");
                portalOrderService.paySuccessByOrderSn(outTradeNo, 1);
            } else {
                log.warn("Order payment not successful, trade_status: {}", tradeStatus);
            }
        } else {
            log.warn("Payment callback signature verification failed!");
        }
        return result;
    }

    @Override
    public String query(String outTradeNo, String tradeNo) {
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        // ******Required parameters******
        JSONObject bizContent = new JSONObject();
        // At least one of out_trade_no or trade_no must be provided
        if (StrUtil.isNotEmpty(outTradeNo)) {
            bizContent.put("out_trade_no", outTradeNo);
        }
        if (StrUtil.isNotEmpty(tradeNo)) {
            bizContent.put("trade_no", tradeNo);
        }
        // Transaction settlement info
        String[] queryOptions = {"trade_settle_info"};
        bizContent.put("query_options", queryOptions);
        request.setBizContent(bizContent.toString());

        AlipayTradeQueryResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            log.error("Query Alipay bill exception!", e);
        }

        if (response.isSuccess()) {
            log.info("Query Alipay bill succeeded!");
            if ("TRADE_SUCCESS".equals(response.getTradeStatus())) {
                portalOrderService.paySuccessByOrderSn(outTradeNo, 1);
            }
        } else {
            log.error("Query Alipay bill failed!");
        }

        // Transaction status: WAIT_BUYER_PAY (created, waiting for buyer),
        // TRADE_CLOSED (unpaid timeout or refunded),
        // TRADE_SUCCESS (payment successful),
        // TRADE_FINISHED (finished, no refund)
        return response.getTradeStatus();
    }

    @Override
    public String webPay(AliPayParam aliPayParam) {
        AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();
        if (StrUtil.isNotEmpty(alipayConfig.getNotifyUrl())) {
            // Asynchronous callback URL, accessible publicly
            request.setNotifyUrl(alipayConfig.getNotifyUrl());
        }
        if (StrUtil.isNotEmpty(alipayConfig.getReturnUrl())) {
            // Synchronous redirect URL
            request.setReturnUrl(alipayConfig.getReturnUrl());
        }
        // ******Required parameters******
        JSONObject bizContent = new JSONObject();
        // Merchant order number, unique
        bizContent.put("out_trade_no", aliPayParam.getOutTradeNo());
        // Payment amount, minimum 0.01
        bizContent.put("total_amount", aliPayParam.getTotalAmount());
        // Order title, special characters not allowed
        bizContent.put("subject", aliPayParam.getSubject());
        // Default value for mobile website payment
        bizContent.put("product_code", "QUICK_WAP_WAY");
        request.setBizContent(bizContent.toString());

        String formHtml = null;
        try {
            formHtml = alipayClient.pageExecute(request).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return formHtml;
    }
}
