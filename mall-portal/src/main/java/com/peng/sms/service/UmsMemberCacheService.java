package com.peng.sms.service;

import com.peng.sms.model.UmsMember;

/**
 * Member information caching service
 */
public interface UmsMemberCacheService {

    /**
     * Delete member cache
     *
     * @param memberId ID of the member
     */
    void delMember(Long memberId);

    /**
     * Get member cache
     *
     * @param memberId ID of the member
     * @return cached member information
     */
    UmsMember getMember(Long memberId);

    /**
     * Set member cache
     *
     * @param member member information
     */
    void setMember(UmsMember member);

    /**
     * Set authentication code
     *
     * @param telephone member's phone number
     * @param authCode  authentication code
     */
    void setAuthCode(String telephone, String authCode);

    /**
     * Get authentication code
     *
     * @param telephone member's phone number
     * @return authentication code
     */
    String getAuthCode(String telephone);
}
