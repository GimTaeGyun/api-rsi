package com.bfly.management.model.customermanagement.slave;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "현재 비밀번호 체크 REQ")
public class PasswordCheckModel {

	@ApiModelProperty(notes = "로그인 한 유저의 사용자아이디(로그인 아이디 아님)", example = "6b2c02c8ffa6db", required = true) 
	private String usrid;
}
