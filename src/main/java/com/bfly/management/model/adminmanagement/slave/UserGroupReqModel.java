package com.bfly.management.model.adminmanagement.slave;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "사용자 그룹 조회 REQ")
public class UserGroupReqModel {
    
    @ApiModelProperty(notes = "action타입 (add: 추가, mod: 수정, del:삭제)", example = "add", required = true) 
    private String action;

    @ApiModelProperty(notes = "사용자 그룹 (생성시 null)", example = "", required = true) 
    private List<Integer> usrGrpId;

    @ApiModelProperty(notes = "상위 사용자 그룹 (최상단 그룹일 경우 null)", example = "", required = true) 
    private String uppUsrGrpId;

    @ApiModelProperty(notes = "사용자그룹명", example = "영업1팀", required = true) 
    private String usrGrpNm;

    @ApiModelProperty(notes = "사용자 그룹 설명", example = "설명칸 입니다.") 
    private String description;
    
}
