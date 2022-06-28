package com.bfly.subscription.model.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorCode implements EnumMapperType {
	// 9000 ~ 9999
	ERROR_ACCESS_DENIED("9000", "접근이 금지되었습니다."),
	ERROR_METHOD_NOT_ALLOWED("9001", "허용되지 않는 메서드입니다."),
	ERROR_NOT_FOUND("9002", "해당 경로를 찾을수 없습니다."),
	ERROR_TYPEMISMATCH("9003", "잘못된 파라미터입니다."),
	ERROR_UNEXPECTED("9004", "서버오류가 발생하였습니다."),
	ERROR_UNAUTHORIZED("9005", "접근권한이 없습니다.");

	private String code;
	private String msg;

	ErrorCode(String code, String msg) {
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
