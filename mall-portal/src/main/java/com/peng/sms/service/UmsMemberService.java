package com.peng.sms.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.peng.sms.model.UmsMember;
import org.springframework.transaction.annotation.Transactional;

/**
 * Member management service
 */
public interface UmsMemberService {

    /**
     * Get member by username
     */
    UmsMember getByUsername(String username);

    /**
     * Get member by ID
     */
    UmsMember getById(Long id);

    /**
     * User registration
     */
    @Transactional
    void register(String username, String password, String telephone, String authCode);

    /**
     * Generate verification code
     */
    String generateAuthCode(String telephone);

    /**
     * Update password
     */
    @Transactional
    void updatePassword(String telephone, String password, String authCode);

    /**
     * Get currently logged-in member
     */
    UmsMember getCurrentMember();

    /**
     * Update member points by member ID
     */
    void updateIntegration(Long id, Integer integration);

    /**
     * Login and return token
     */
    SaTokenInfo login(String username, String password);

    /**
     * Logout
     */
    void logout();
}
