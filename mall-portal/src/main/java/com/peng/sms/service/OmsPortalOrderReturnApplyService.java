package com.peng.sms.service;

import com.peng.sms.domain.OmsOrderReturnApplyParam;

/**
 * Order Return Management Service
 */
public interface OmsPortalOrderReturnApplyService {

    /**
     * Submit a return request
     */
    int create(OmsOrderReturnApplyParam returnApply);
}
