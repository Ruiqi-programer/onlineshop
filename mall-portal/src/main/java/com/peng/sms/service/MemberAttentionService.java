package com.peng.sms.service;

import com.peng.sms.domain.MemberBrandAttention;
import org.springframework.data.domain.Page;

/**
 * Member Attention Service
 */
public interface MemberAttentionService {

    /**
     * Add a brand to member's attention/follow list
     */
    int add(MemberBrandAttention memberBrandAttention);

    /**
     * Remove a brand from member's attention/follow list
     */
    int delete(Long brandId);

    /**
     * Get the list of brands the member is following
     */
    Page<MemberBrandAttention> list(Integer pageNum, Integer pageSize);

    /**
     * Get details of a specific brand the member is following
     */
    MemberBrandAttention detail(Long brandId);

    /**
     * Clear all followed brands
     */
    void clear();
}
