package com.peng.sms.controller;

import com.peng.sms.api.CommonPage;
import com.peng.sms.api.CommonResult;
import com.peng.sms.model.PmsProduct;
import com.peng.sms.domain.PmsPortalProductDetail;
import com.peng.sms.domain.PmsProductCategoryNode;
import com.peng.sms.service.PmsPortalProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Portal Product Management Controller
 * Created by macro on 2020/4/6.
 */
@Controller
@Tag(name = "PmsPortalProductController", description = "Portal Product Management")
@RequestMapping("/product")
public class PmsPortalProductController {

    @Autowired
    private PmsPortalProductService portalProductService;

    @Operation(summary = "Comprehensive search, filter, and sort")
    @Parameter(name = "sort", description = "Sort field: 0->by relevance; 1->by new arrivals; 2->by sales; 3->price low to high; 4->price high to low",
            in= ParameterIn.QUERY, schema = @Schema(type = "integer", defaultValue = "0", allowableValues = {"0","1","2","3","4"}))
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsProduct>> search(@RequestParam(required = false) String keyword,
                                                       @RequestParam(required = false) Long brandId,
                                                       @RequestParam(required = false) Long productCategoryId,
                                                       @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                       @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                                                       @RequestParam(required = false, defaultValue = "0") Integer sort) {
        List<PmsProduct> productList = portalProductService.search(keyword, brandId, productCategoryId, pageNum, pageSize, sort);
        return CommonResult.success(CommonPage.restPage(productList));
    }

    @Operation(summary = "Get all product categories in tree structure")
    @RequestMapping(value = "/categoryTreeList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsProductCategoryNode>> categoryTreeList() {
        List<PmsProductCategoryNode> list = portalProductService.categoryTreeList();
        return CommonResult.success(list);
    }

    @Operation(summary = "Get portal product details")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsPortalProductDetail> detail(@PathVariable Long id) {
        PmsPortalProductDetail productDetail = portalProductService.detail(id);
        return CommonResult.success(productDetail);
    }
}