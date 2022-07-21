package com.bfly.management.customermanagement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bfly.management.customermanagement.service.EmailService;
import com.bfly.management.model.common.ApiResult;
import com.bfly.management.model.customermanagement.slave.EmailAuthCheckReqModel;
import com.bfly.management.model.customermanagement.slave.EmailAuthReqModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
// import lombok.extern.slf4j.Slf4j;

// @Slf4j
@RestController
@Api( tags = "Email API")
@RequestMapping(value="/customer/email", produces = { "application/json" })
public class EmailController {
    
    @Autowired
    EmailService emailService;
    
	/**
	 * 가입완료 메일링
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "가입완료 메일링", notes = "가입완료 메일링")
	@PostMapping("/complete/join")
	public ApiResult<?> completeJoin(HttpServletRequest request, 
												@RequestParam @NotBlank(message = "param값은 필수입니다.") String email, String username) throws Exception {
		return emailService.completeJoin(email, username);
	}

	/**
	 * 이메일 인증 번호 발송 ( 1분내 5회 시도 x )
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "이메일 인증", notes = "이메일 인증")
	@PostMapping("/authenticate")
	public ApiResult<?> emailAuthenticate(HttpServletRequest request, @RequestBody @NotBlank(message = "param값은 필수입니다.") EmailAuthReqModel param) throws Exception {
		return emailService.emailAuthenticate(param);
	}

	/**
	 * 이메일 인증 번호 체크
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "이메일 인증 확인", notes = "이메일 인증 확인")
	@PostMapping("/check/authenticate")
	public ApiResult<?> checkAuthenticate(HttpServletRequest request, @RequestBody @NotBlank(message = "param값은 필수입니다.") EmailAuthCheckReqModel param) throws Exception {
		return emailService.checkAuthenticate(param);
	}
}
