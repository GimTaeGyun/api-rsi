package com.bfly.management.customermanagement.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bfly.management.customermanagement.service.LoginService;
import com.bfly.management.model.common.ApiResult;
import com.bfly.management.model.customermanagement.slave.LoginReqModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = "로그인 API")
@RestController
@Validated
@RequestMapping(value = "/customer", produces = { "application/json" })
public class LoginController {
    
    @Autowired
    LoginService loginService;

    @ApiOperation(value = "로그인", notes = "로그인")
	@PostMapping("login")
	public ApiResult<HashMap<String, Object>> login(
		HttpServletRequest request,
		@RequestBody  LoginReqModel param
		)
			throws Exception {
		return loginService.login(param);
	}

}
