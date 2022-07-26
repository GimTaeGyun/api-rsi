package com.bfly.management.contractmanagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bfly.management.contractmanagement.service.CmSubscriptionService;
import com.bfly.management.customermanagement.service.CuLoginService;
import com.bfly.management.model.common.ApiResult;
import com.bfly.management.model.contractmanagement.master.CartUpdateReqModel;
import com.bfly.management.model.contractmanagement.slave.CartReqModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api( tags = "통합구독 - 계약구독결제 API")
@RequestMapping(value="/subscription", produces = { "application/json" })
public class CmSubscriptionController {
    @Autowired
    CmSubscriptionService cmSubscriptionService;

	@Autowired
    CuLoginService loginService;

	/**
	 * 장바구니 조회
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "장바구니 조회", notes = "장바구니 조회 ( p_cust_id : 고객ID )")
	@PostMapping("/contract/cart/inquiry")
	public ApiResult<?> getCartInfo(@Valid @RequestBody CartReqModel param) throws Exception {
		return cmSubscriptionService.getCartInfo(param);
	}

	/**
	 * 장바구니 추가, 수정, 삭제
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "장바구니 추가, 수정, 삭제", notes = "장바구니 추가, 수정, 삭제")
	@PostMapping("/contract/cart/update")
	public ApiResult<?> setCartInfo(@Valid @RequestBody CartUpdateReqModel param) throws Exception {
		return cmSubscriptionService.setCartInfo(param);
	}

}