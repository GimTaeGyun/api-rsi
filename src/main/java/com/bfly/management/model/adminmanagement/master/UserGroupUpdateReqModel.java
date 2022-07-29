package com.bfly.management.model.adminmanagement.master;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "사용자 그룹 추가/수정/삭제 REQ")
public class UserGroupUpdateReqModel {
    
    @ApiModelProperty(notes = "action type (add: 추가, mod: 수정, del:삭제)", example = "mod", required = true)
    private String action;
    
    @ApiModelProperty(notes = "사용자 그룹 (add: null) (mod, del: 그룹 번호)", example = "9", required = true)
    private String usrGrpId;

    @ApiModelProperty(notes = "상위 사용자 그룹 (최상단 그룹일 경우 null)", example = "6", required = true)
    private String uppUsrGrpId;

    @ApiModelProperty(notes = "사용자 그룹 역할", example = "[\"FINANCE\",\"SALES\"]", required = true)
    private List<String> usrRoleId;

    @ApiModelProperty(notes = "사용자 그룹명", example = "영업1팀", required = true)
    private String usrGrpNm;

    @ApiModelProperty(notes = "사용자 그룹 설명", example = "이건 설명칸 입니다.")
    private String description;
}
