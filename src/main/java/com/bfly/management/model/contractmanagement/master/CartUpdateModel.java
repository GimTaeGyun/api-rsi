package com.bfly.management.model.contractmanagement.master;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartUpdateModel {
    
    @ApiModelProperty(notes = "상품 ID", example = "1", required = true) 
    private Integer prdId;

    @ApiModelProperty(notes = "상품 아이템 ID", example = "[\"1\",\"2\",\"3\",\"6\",\"179\",\"182\"]", required = true) 
    private List<Integer> prdItems;

    private List<CartItemUpdateModel> prdOptions;
}
