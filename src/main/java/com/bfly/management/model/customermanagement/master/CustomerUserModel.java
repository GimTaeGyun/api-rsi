package com.bfly.management.model.customermanagement.master;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerUserModel {
    
    @ApiModelProperty(notes = "action type (add: 추가, mod: 수정, del:삭제)", example = "add", required = true) 
    private String action;

    @ApiModelProperty(notes = "속해있는 사용자그룹", example = "1", required = true) 
    private String grpNo;

    @ApiModelProperty(notes = "사용자명", example = "유저1", required = true)
    private String usrNm;

    @ApiModelProperty(notes = "로그인 아이디", example = "g9soft", required = true)
    private String loginId;

    @ApiModelProperty(notes = "로그인 비밀번호", example = "g9soft", required = true)
    private String loginPw;

    @ApiModelProperty(notes = "연락처", example = "010-4545-5656", required = true)
    private String phone;

    @ApiModelProperty(notes = "이메일", example = "g9soft@gmail.com", required = true)
    private String email;

}
