package com.bfly.management.customermanagement.controller;


import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bfly.management.customermanagement.service.CuSubscriptionService;
import com.bfly.management.customermanagement.service.CuLoginService;
import com.bfly.management.model.common.ApiResult;
import com.bfly.management.model.customermanagement.master.CustomerInfoModel;
import com.bfly.management.model.customermanagement.master.CustomerUserGroupModel;
import com.bfly.management.model.customermanagement.master.CustomerUserModel;
import com.bfly.management.model.customermanagement.slave.CustomerCheckModel;
import com.bfly.management.model.customermanagement.slave.LoginReqModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api( tags = "통합구독 - 고객관리 API")
@RequestMapping(value="/subscription", produces = { "application/json" })
public class CuSubscriptionController {
    @Autowired
    CuSubscriptionService cuSubscriptionService;

	@Autowired
    CuLoginService loginService;

	/**
	 * 고객관리 로그인
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "로그인", notes = "로그인")
	@PostMapping("/customer/login")
	public ApiResult<HashMap<String, Object>> login(HttpServletRequest request, @RequestBody LoginReqModel param) throws Exception {
		return loginService.customerLogin(param);
	}

	/**
	 * 고객관리 고객가입
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "고객 가입", notes = "고객 가입 ( sid : 서비스 ID )")
	@PostMapping("/customer/signup")
	public ApiResult<?> createCustomer(@Valid @RequestBody CustomerInfoModel param) throws Exception {
		return cuSubscriptionService.createCustomer(param);
	}

	/**
	 * 고객관리 고객정보 체크
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "고객정보 체크", notes = "field : 체크 항목, value1 : 값1, value2: 값2 (상세한 설명은 Model Example 참고)")
	@PostMapping("/customer/check")
	public ApiResult<?> checkCustomer(@Valid @RequestBody CustomerCheckModel param) throws Exception {
		return cuSubscriptionService.checkCustomer(param);
	}

	/**
	 * 고객관리 사용자 그룹 추가/수정/삭제
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "사용자 그룹 추가/수정/삭제", notes = "사용자 그룹 추가/수정/삭제")
	@PostMapping("/customer/usergroup/update")
	public ApiResult<?> setCustUserGroup(@Valid @RequestBody CustomerUserGroupModel param) throws Exception {
		return cuSubscriptionService.setCustUserGroup(param);
	}

	/**
	 * 고객관리 사용자 추가/수정/삭제
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "사용자 추가/수정/삭제", notes = "사용자 추가/수정/삭제")
	@PostMapping("/customer/user/update")
	public ApiResult<?> setCustUser(@Valid @RequestBody CustomerUserModel param) throws Exception {
		return cuSubscriptionService.setCustUser(param);
	}

	
}