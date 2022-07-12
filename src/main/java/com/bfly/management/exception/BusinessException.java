package com.bfly.management.exception;

import com.bfly.management.model.common.EnumMapperType;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ACCEPTED)
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = -4371944134550491215L;

	private Enum<? extends EnumMapperType> code;

	public Enum<? extends EnumMapperType> getCode() {
		return code;
	}

	public BusinessException(Enum<? extends EnumMapperType> code) {
		this.code = code;
	}

	public BusinessException(Enum<? extends EnumMapperType> code, Throwable t) {
		super(t);
		this.code = code;
	}
}