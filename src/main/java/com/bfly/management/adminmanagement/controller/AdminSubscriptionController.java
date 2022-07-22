package com.bfly.management.adminmanagement.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bfly.management.adminmanagement.service.AdminLoginService;
import com.bfly.management.adminmanagement.service.AdminSubscriptionService;
import com.bfly.management.model.adminmanagement.master.UserChangePwReqModel;
import com.bfly.management.model.adminmanagement.master.UserDelMoveReqModel;
import com.bfly.management.model.adminmanagement.master.UserUpdateReqModel;
import com.bfly.management.model.adminmanagement.slave.AdminCheckDupIdReqModel;
import com.bfly.management.model.adminmanagement.slave.AdminLoginReqModel;
import com.bfly.management.model.adminmanagement.slave.MenuReqModel;
import com.bfly.management.model.adminmanagement.slave.UserGroupReqModel;
import com.bfly.management.model.adminmanagement.slave.UserGroupUpdateReqModel;
import com.bfly.management.model.adminmanagement.slave.UserReqModel;
import com.bfly.management.model.common.ApiResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api( tags = "통합구독 - 어드민 API")
@RequestMapping(value="/subscription", produces = { "application/json" })
public class AdminSubscriptionController {
    @Autowired
    AdminSubscriptionService adminSubscriptionService;

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
		return loginService.adminLogin(param);
	}

	/**
	 * 사용자 추가, 수정
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "사용자 추가, 수정", notes = "사용자 추가, 수정")
	@PostMapping("/admin/user/update")
	public ApiResult<?> setUser(@Valid @RequestBody UserUpdateReqModel param) throws Exception {
		return adminSubscriptionService.setUser(param);
	}

	/**
	 * 사용자 삭제/이동
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "사용자 삭제/이동", notes = "사용자 삭제/이동")
	@PostMapping("/admin/user/delete")
	public ApiResult<?> delMoveUser(@Valid @RequestBody UserDelMoveReqModel param) throws Exception {
		return adminSubscriptionService.delMoveUser(param);
	}

	/**
	 * 사용자 검색
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "사용자 검색", notes = "사용자 검색")
	@PostMapping("/admin/user/inquiry")
	public ApiResult<?> selectUser(@Valid @RequestBody UserReqModel param) throws Exception {
		return adminSubscriptionService.selectUser(param);
	}

	/**
	 * 사용자 그룹 추가/생성/삭제
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "사용자 그룹 추가/생성/삭제", notes = "사용자 그룹 추가/생성/삭제")
	@PostMapping("/admin/usergroup/update")
	public ApiResult<?> selectUserGroup(@Valid @RequestBody UserGroupUpdateReqModel param) throws Exception {
		return adminSubscriptionService.selectUserGroup(param);
	}

	/**
	 * 사용자 비밀번호 변경
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "사용자 비밀번호 변경", notes = "사용자 비밀번호 변경")
	@PostMapping("/admin/userpw/update")
	public ApiResult<?> changeUserPw(@Valid @RequestBody UserChangePwReqModel param) throws Exception {
		return adminSubscriptionService.changeUserPw(param);
	}

	/**
	 * 메뉴리스트 및 페이지리스트 조회
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "메뉴리스트 및 페이지리스트 조회", notes = "메뉴리스트 및 페이지리스트 조회")
	@PostMapping("/admin/menu/inquiry")
	public ApiResult<?> selectMenu(@Valid @RequestBody MenuReqModel param) throws Exception {
		return adminSubscriptionService.selectMenu(param);
	}

	/**
	 * 어드민 - 사용자 아이디 중복 확인
	 * @param request
	 * @param param
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "사용자 아이디 중복 확인", notes = "사용자 아이디 중복 확인")
	@PostMapping("/admin/user/chkDupId")
	public ApiResult<?> checkDupId(@Valid @RequestBody AdminCheckDupIdReqModel param) throws Exception {
		return adminSubscriptionService.checkDupId(param);
	}

}