package com.bfly.management.model.productmanagement.master;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "옵션카테고리 추가, 수정, 삭제 REQ")
public class OptionCategoryUpdateReqModel {
    
    @ApiModelProperty(notes = "작업수행자 로그인계정", example = "user_adm1", required = true) 
    private String actor;

    @ApiModelProperty(notes = "유형: add(추가), mod(수정), del(삭제)", example = "add", required = true) 
    private String paramType;

    private List<OptionDatasetModel> dataset;
    
}
