package com.bfly.management.model.adminmanagement.slave;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "사용자 그룹 조회 REQ")
public class UserGroupReqModel {
    
    @ApiModelProperty(notes = "조회할 그룹아이디(전체 그룹 및 사용자 조회일 경우:1)", example = "1", required = true)
    private String usrGrpId;
    
}
