package com.bfly.management.model.customermanagement.master;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerUserGroupModel {
    
    @ApiModelProperty(notes = "action type (add: 추가, mod: 수정, del:삭제)", example = "add", required = true) 
    private String action;

    @ApiModelProperty(notes = "고객 아이디", example = "e2dbe905af0ff06cc88e55dcf4c543e8", required = true) 
    private String custId;

    @ApiModelProperty(notes = "고객 사용자 그룹 번호 (add: null)(mod,del: 그룹 번호)", example = "1", required = true)
    private String custGrpNo;

    @ApiModelProperty(notes = "고객 사용자 그룹명", example = "고객 사용자 그룹1", required = true)
    private String custGrpNm;

    @ApiModelProperty(notes = "고객 사용자 그룹 설명", example = "고객 사용자 그룹1 입니다.")
    private String description;

}
