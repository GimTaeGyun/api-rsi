package com.bfly.management.model.adminmanagement.slave;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "사용자 조회 REQ")
public class UserReqModel {
    
    @ApiModelProperty(notes = "사용자 아이디(로그인 아이디 아님)", example = "sysadm", required = true)
    private String usrId;
    
    @ApiModelProperty(notes = "사용자 명", example = "시스템어드민", required = true)
    private String usrNm;

    @ApiModelProperty(notes = "사용자 상태(1:활성화, 0:비활성화)", example = "1", required = true)
    private String status;
}
