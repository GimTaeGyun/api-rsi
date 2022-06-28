package com.bfly.subscription.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bfly.subscription.model.common.ApiResult;
import com.bfly.subscription.model.common.CommonCode;
import com.bfly.subscription.service.FileService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Api( tags = "File API")
@RequestMapping(value="/file", produces = { "application/json" })
public class FileController {
    
    @Autowired
    FileService fileService;

    
	/**
	 * 사업자등록증 업로드 및 OCR 데이터 파싱
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "사업자등록증 업로드", notes = "사업자등록증 업로드")
	@PostMapping("/upload/license")
	public ApiResult<?> uploadLicense(HttpServletRequest request, @RequestParam @NotBlank(message = "param값은 필수입니다.") String param) throws Exception {
		log.info(param);
		return fileService.uploadLicense(param);
	}
}
