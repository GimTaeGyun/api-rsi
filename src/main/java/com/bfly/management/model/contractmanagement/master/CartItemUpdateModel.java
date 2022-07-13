package com.bfly.management.model.contractmanagement.master;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemUpdateModel {
    
    @ApiModelProperty(notes = "상품 옵션 ID", example = "6") 
    private Integer optId;

    @ApiModelProperty(notes = "옵션 아이템 ID", example = "1") 
    private Integer itemId;

    @ApiModelProperty(notes = "옵션 구분(PRD:상품옵션, PRD_GRP:상품그룹옵션) ", example = "PRD", required = true) 
    private String optCls;

}
