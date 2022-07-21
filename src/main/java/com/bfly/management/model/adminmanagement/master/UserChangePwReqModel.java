package com.bfly.management.model.adminmanagement.master;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "사용자 비밀번호 변경 REQ")
public class UserChangePwReqModel {
    
    @ApiModelProperty(notes = "사용자 아이디", example = "test1111", required = true)
    private String usrId;

    @ApiModelProperty(notes = "변경할 비밀번호", example = "test", required = true)
    private String usrPw;
    
    

}
