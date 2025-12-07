package com.peng.sms.mapper;

import com.peng.sms.model.SmsHomeRecommendSubject;
import com.peng.sms.model.SmsHomeRecommendSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsHomeRecommendSubjectMapper {
    long countByExample(SmsHomeRecommendSubjectExample example);

    int deleteByExample(SmsHomeRecommendSubjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsHomeRecommendSubject row);

    int insertSelective(SmsHomeRecommendSubject row);

    List<SmsHomeRecommendSubject> selectByExample(SmsHomeRecommendSubjectExample example);

    SmsHomeRecommendSubject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") SmsHomeRecommendSubject row, @Param("example") SmsHomeRecommendSubjectExample example);

    int updateByExample(@Param("row") SmsHomeRecommendSubject row, @Param("example") SmsHomeRecommendSubjectExample example);

    int updateByPrimaryKeySelective(SmsHomeRecommendSubject row);

    int updateByPrimaryKey(SmsHomeRecommendSubject row);
}