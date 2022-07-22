package com.bfly.management.model.adminmanagement.master;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "사용자 삭제/이동")
public class UserDelMoveReqModel {

    @ApiModelProperty(notes = "action type (del:삭제, mod: 이동)", example = "mod", required = true) 
    private String action;

    @ApiModelProperty(notes = "사용자 아이디(여러명일 경우 ,로 구분)", example = "[\"g10soft\",\"test111\"]", required = true) 
    private List<String> usrId;

    @ApiModelProperty(notes = "이동시 이동할 그룹리스트(여러 그룹일 경우 ,로 구분)", example = "[1, 2]", required = true) 
    private List<Integer> usrGrpId;

}
