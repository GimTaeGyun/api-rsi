package com.bfly.management.model.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CommonCode implements EnumMapperType {
	// 0 ~ 0999
	COMMON_SUCCESS("0000", "성공"),
	COMMON_LOGIN_NOT_VALID_ID_PASSWORD("0901", "사용자 아이디나 비밀번호가 잘못되었습니다."),
	COMMON_LOGIN_NOT_VALID_CTRT("0902", "유효한 계약이 없습니다."),
	COMMON_LOGIN_EXPIRED_CTRT("0903", "해당 계정은 계약기간이 만료되었습니다."),
	COMMON_PWD_COMPARE_INVALID("0904", "새 비밀번호와 확인 비밀번호값이 틀립니다."),
	COMMON_ID_CASE_INVALID("0905", "아이디에 대문자가 포함되어 있습니다."),
	COMMON_FAIL("0999", "실패");

	private String code;
	private String msg;

	CommonCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public String getMsg() {
		return this.msg;
	}
}
