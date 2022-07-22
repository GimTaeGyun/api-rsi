package com.bfly.management.model.adminmanagement.slave;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "메뉴리스트 및 페이지리스트 조회 REQ")
public class MenuReqModel {

    @ApiModelProperty(notes = "조회할 어플리케이션아이디(관리자는 1)", example = "1", required = true)
    private String appId;

    @ApiModelProperty(notes = "조회할 메뉴아이디(전체는 0)", example = "0", required = true)
    private String menuId;

    @ApiModelProperty(notes = "로그인 한 유저의 아이디", example = "sysadm", required = true)
    private String usrId;
}
