package com.bfly.management.model.adminmanagement.slave;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "사용자 이이디 중복 확인 REQ")
public class AdminCheckDupIdReqModel {

	@ApiModelProperty(notes = "입력한 유저 아이디", example = "test111", required = true) 
	private String usrId;

}
