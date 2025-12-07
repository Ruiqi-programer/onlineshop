package com.peng.sms.service;

import com.peng.sms.domain.MemberProductCollection;
import org.springframework.data.domain.Page;

/**
 * Member Product Collection Service
 */
public interface MemberCollectionService {
    /**
     * Add a product to the member's collection
     */
    int add(MemberProductCollection productCollection);

    /**
     * Remove a product from the member's collection
     */
    int delete(Long productId);

    /**
     * Get a paginated list of collected products
     */
    Page<MemberProductCollection> list(Integer pageNum, Integer pageSize);

    /**
     * Get details of a collected product
     */
    MemberProductCollection detail(Long productId);

    /**
     * Clear all collected products
     */
    void clear();
}
