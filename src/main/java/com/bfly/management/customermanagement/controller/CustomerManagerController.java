package com.bfly.management.customermanagement.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bfly.management.customermanagement.service.CustomerManagerService;
import com.bfly.management.model.common.ApiResult;
import com.bfly.management.model.customermanagement.master.CustomerInfoModel;
import com.bfly.management.model.customermanagement.slave.CustomerCheckModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api( tags = "Manager API")
@RequestMapping(value="/customer/manager", produces = { "application/json" })
public class CustomerManagerController {
    @Autowired
    CustomerManagerService customerManageService;

	/**
	 * 고객관리 고객가입
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "고객 가입", notes = "고객 가입 ( sid : 서비스 ID )")
	@PostMapping("/signup")
	public ApiResult<?> createCustomer(@Valid @RequestBody CustomerInfoModel param) throws Exception {
		return customerManageService.createCustomer(param);
	}

	/**
	 * 고객관리 고객정보 체크
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "고객정보 체크", notes = "고객정보 체크")
	@PostMapping("/check")
	public ApiResult<?> checkCustomer(@Valid @RequestBody CustomerCheckModel param) throws Exception {
		return customerManageService.checkCustomer(param);
	}

}