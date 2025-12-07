package com.peng.sms.dao;

import com.peng.sms.domain.SmsCouponHistoryDetail;
import com.peng.sms.model.SmsCoupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Custom DAO for member coupon redemption history
 */
public interface SmsCouponHistoryDao {
    List<SmsCouponHistoryDetail> getDetailList(@Param("memberId") Long memberId);

    List<SmsCoupon> getCouponList(@Param("memberId") Long memberId, @Param("useStatus") Integer useStatus);
}
