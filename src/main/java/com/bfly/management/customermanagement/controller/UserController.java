package com.bfly.management.customermanagement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bfly.management.customermanagement.service.UserService;
import com.bfly.management.model.common.ApiResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@Api( tags = "User API")
@RequestMapping(value="/customer/user", produces = { "application/json" })
public class UserController {

    @Autowired
    UserService userService;

	/**
	 * 로그인 및 인증토큰 발급
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "로그인", notes = "로그인")
	@PostMapping("/login")
	public ApiResult<?> userLogin(HttpServletRequest request, @RequestParam @NotBlank(message = "param값은 필수입니다.") String param) throws Exception {
        log.info(param);
		return userService.userLogin(param);
	}

	/**
	 * 회원가입
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "회원가입", notes = "회원가입")
	@PostMapping("/join")
	public ApiResult<?> userJoin(HttpServletRequest request, @RequestParam @NotBlank(message = "param값은 필수입니다.") String param) throws Exception {
        log.info(param);
		return userService.userJoin(param);
	}

	/**
	 * 사용자 정보 가져오기
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "사용자 정보 저장", notes = "사용자 정보 저장")
	@PostMapping("/{userId}")
	public ApiResult<?> userInfo(
		HttpServletRequest request, 
		@ApiParam(value = "사용자ID", required = true) @NotBlank(message = "사용자ID는 필수값입니다.") @PathVariable("userId") String userId)
		throws Exception {
        log.info(userId);
		return userService.userInfo(userId);
	}

	/**
	 * 사용자 정보 저장 ( 전체 업데이트 처리 )
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "사용자 정보 저장", notes = "사용자 정보 저장")
	@PostMapping("/update")
	public ApiResult<?> userUpdate(HttpServletRequest request, @RequestParam @NotBlank(message = "param값은 필수입니다.") String param) throws Exception {
        log.info(param);
		return userService.userUpdate(param);
	}

	/**
	 * 아이디 찾기
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "아이디 찾기", notes = "아이디 찾기")
	@PostMapping("/find/id")
	public ApiResult<?> findId(HttpServletRequest request, @RequestParam @NotBlank(message = "param값은 필수입니다.") String param) throws Exception {
        log.info(param);
		return userService.findId(param);
	}

	/**
	 * 패드워드 찾기
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "패스워드 찾기", notes = "패스워드 찾기")
	@PostMapping("/find/password")
	public ApiResult<?> findPassword(HttpServletRequest request, @RequestParam @NotBlank(message = "param값은 필수입니다.") String param) throws Exception {
        log.info(param);
		return userService.findPassword(param);
	}

    /**
     * 패드워드 초기화 URL 및 Token 생성
     * @param request
     * @param param
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "패스워드 초기화", notes = "패스워드 초기화")
	@PostMapping("/reset/password")
	public ApiResult<?> resetPassword(HttpServletRequest request, @RequestParam @NotBlank(message = "param값은 필수입니다.") String param) throws Exception {
        log.info(param);
		return userService.resetPassword(param);
	}

	@ApiOperation(value = "패스워드 암호화", notes = "패스워드 암호화")
	@PostMapping("/encrypt/password")
	public ApiResult<?> passwordEncrypt(@RequestParam @NotBlank(message = "param값은 필수입니다.") String password){
		log.info(password);
		return userService.passwordEncrypt(password);
	}
}
