package com.bfly.management.model.adminmanagement.master;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "사용자 추가, 수정")
public class UserUpdateReqModel {

    @ApiModelProperty(notes = "action타입 add(추가), mod(수정)", example = "add", required = true) 
    private String action;

    @ApiModelProperty(notes = "사용자 그룹아이디(다수개일 경우 ,로 구분 ex.1,2,3)", example = "[\"1\",\"2\",\"3\"]", required = true) 
    private List<Integer> usrGrpId;

    @ApiModelProperty(notes = "사용자 아이디", example = "g9soft", required = true) 
    private String usrId;

    @ApiModelProperty(notes = "사용자 비밀번호", example = "g9soft", required = true) 
    private String usrPw;

    @ApiModelProperty(notes = "사용자 명", example = "지구소프트", required = true) 
    private String usrNm;

    @ApiModelProperty(notes = "사용자 휴대폰 번호", example = "010-0000-0000", required = true) 
    private String phone;

    @ApiModelProperty(notes = "사용자 이메일", example = "bfly@bflysoft.com", required = true) 
    private String email;

    @ApiModelProperty(notes = "사용자 유형 (기본: DEFAULT)", example = "DEFAULT", required = true) 
    private String usrTp;

    @ApiModelProperty(notes = "상태값 (활성화:1, 비활성화:0)", example = "1", required = true) 
    private int status;

}
