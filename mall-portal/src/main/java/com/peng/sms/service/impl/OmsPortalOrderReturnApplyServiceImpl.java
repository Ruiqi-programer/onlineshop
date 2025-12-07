package com.peng.sms.service.impl;

import com.peng.sms.domain.OmsOrderReturnApplyParam;
import com.peng.sms.mapper.OmsOrderReturnApplyMapper;
import com.peng.sms.model.OmsOrderReturnApply;
import com.peng.sms.service.OmsPortalOrderReturnApplyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Order Return Management Service Implementation
 */
@Service
public class OmsPortalOrderReturnApplyServiceImpl implements OmsPortalOrderReturnApplyService {
    @Autowired
    private OmsOrderReturnApplyMapper returnApplyMapper;

    @Override
    public int create(OmsOrderReturnApplyParam returnApply) {
        OmsOrderReturnApply realApply = new OmsOrderReturnApply();
        // Copy properties from the input parameter to the actual entity
        BeanUtils.copyProperties(returnApply, realApply);
        realApply.setCreateTime(new Date()); // Set creation time
        realApply.setStatus(0); // Set initial status to 0 (pending)
        return returnApplyMapper.insert(realApply); // Insert the return application into the database
    }
}
