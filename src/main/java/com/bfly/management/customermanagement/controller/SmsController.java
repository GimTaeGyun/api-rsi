package com.bfly.management.customermanagement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bfly.management.customermanagement.service.SmsService;
import com.bfly.management.model.common.ApiResult;
import com.bfly.management.model.common.CommonCode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@Api( tags = "SMS API")
@RequestMapping(value="/customer/sms", produces = { "application/json" })
public class SmsController {
    
    @Autowired
    SmsService smsService;

    /**
	 * SMS 인증 ( 하루 10회 제한 및 제한시간 처리 )
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "SMS인증", notes = "SMS인증")
	@PostMapping("/authentication")
	public ApiResult<?> userSmsCertified(HttpServletRequest request, @RequestParam @NotBlank(message = "param값은 필수입니다.") String param) throws Exception {
        log.info(param);
		return smsService.userSmsCertified(param);
	}

	/**
	 * SMS 인증 확인
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "SMS인증확인", notes = "SMS인증확인")
	@PostMapping("/authentication/check")
	public ApiResult<?> userSmsCertifiedCheck(HttpServletRequest request, @RequestParam @NotBlank(message = "param값은 필수입니다.") String param) throws Exception {
        log.info(param);
		return smsService.userSmsCertifiedCheck(param);
	}

}
