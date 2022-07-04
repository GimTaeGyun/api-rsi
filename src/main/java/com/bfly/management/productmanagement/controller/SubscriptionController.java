package com.bfly.management.productmanagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bfly.management.model.common.ApiResult;
import com.bfly.management.model.productmanagement.slave.ProductDetailItemReqModel;
import com.bfly.management.productmanagement.service.SubscriptionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api( tags = "Subscription API")
@RequestMapping(value="/subscription", produces = { "application/json" })
public class SubscriptionController {
    
    @Autowired
    SubscriptionService subscriptionService;

    /**
	 * 상품 리스트 상세조회
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "상품 리스트 상세조회", notes = "상품 리스트 상세조회 ( p_prd_id : 상품ID )")
	@PostMapping("/product/detail/inquiry")
	public ApiResult<?> getProduct(@Valid @RequestBody ProductDetailItemReqModel param) throws Exception {
		return subscriptionService.getProductDetail(param);
	}
}
