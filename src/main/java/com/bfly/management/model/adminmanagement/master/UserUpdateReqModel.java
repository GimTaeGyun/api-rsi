package com.bfly.management.model.adminmanagement.master;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "사용자 추가, 수정, 삭제")
public class UserUpdateReqModel {
    
    @ApiModelProperty(notes = "고객 ID", example = "11494ff3b8d93df129ff10e5d30c6bd4", required = true) 
    private String custId;

    @ApiModelProperty(notes = "유형: add(추가), mod(수정), del(삭제)", example = "add", required = true) 
    private String paramType;

    // private List<CartUpdateModel> dataset;
}
