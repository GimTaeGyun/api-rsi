package com.bfly.management.model.adminmanagement.slave;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "사용자 상세 정보 조회 REQ")
public class UserInfoReqModel {
    
    @ApiModelProperty(notes = "입력한 유저 아이디", example = "g5soft", required = true)
    private String usrId;
}
