package com.bfly.management.model.customermanagement.slave;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "로그인 REQ")
public class LoginReqModel {

	@ApiModelProperty(notes = "로그인 ID", example = "g9soft", required = true) 
	private String usrId;

	@ApiModelProperty(notes = "로그인 비밀번호", example = "g9soft", required = true) 
	private String usrPw;

}
