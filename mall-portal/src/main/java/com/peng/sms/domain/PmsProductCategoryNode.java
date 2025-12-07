package com.peng.sms.domain;

import com.peng.sms.model.PmsProductCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Product category including subcategories
 * Created by macro on 2020/4/6.
 */
@Getter
@Setter
public class PmsProductCategoryNode extends PmsProductCategory {
    // Subcategories
    private List<PmsProductCategoryNode> children;
}
