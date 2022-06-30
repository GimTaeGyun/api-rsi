package com.bfly.management.model.productmanagement.master;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "상품 그룹 추가, 수정, 삭제")
public class ProductUpdateReqModel {
    
    @ApiModelProperty(notes = "유형: add(추가), mod(수정), del(삭제)", example = "add", required = true) 
    private String paramType;

    private List<ProductGroupModel> dataset;
}
