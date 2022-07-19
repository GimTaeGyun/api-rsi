package com.bfly.management.adminmanagement.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bfly.management.adminmanagement.service.AdminLoginService;
import com.bfly.management.contractmanagement.service.CmSubscriptionService;
import com.bfly.management.model.adminmanagement.slave.AdminLoginReqModel;
import com.bfly.management.model.common.ApiResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api( tags = "통합구독 - 어드민 API")
@RequestMapping(value="/subscription", produces = { "application/json" })
public class AdminSubscriptionController {
    @Autowired
    CmSubscriptionService cmSubscriptionService;

	@Autowired
    AdminLoginService loginService;

	/**
	 * 어드민 로그인
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "어드민 로그인", notes = "어드민 로그인")
	@PostMapping("/admin/login")
	public ApiResult<HashMap<String, Object>> login(HttpServletRequest request, @RequestBody AdminLoginReqModel param) throws Exception {
		return loginService.login(param);
	}

	// /**
	//  * 사용자 추가, 수정, 삭제
	//  * @param request
	//  * @param param
	//  * @return
	//  * @throws Exception
	//  */
    // @ApiOperation(value = "사용자 추가, 수정, 삭제", notes = "사용자 추가, 수정, 삭제")
	// @PostMapping("/admin/cart/update")
	// public ApiResult<?> setCartInfo(@Valid @RequestBody CartUpdateReqModel param) throws Exception {
	// 	return cmSubscriptionService.setCartInfo(param);
	// }

	

}