package com.peng.sms.service;

import com.peng.sms.domain.MemberReadHistory;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Member Browsing History Management Service
 */
public interface MemberReadHistoryService {

    /**
     * Create a browsing record
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * Delete browsing records in bulk
     */
    int delete(List<String> ids);

    /**
     * Get paginated list of user's browsing history
     */
    Page<MemberReadHistory> list(Integer pageNum, Integer pageSize);

    /**
     * Clear all browsing records
     */
    void clear();
}
