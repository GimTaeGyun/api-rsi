package com.bfly.management.model.productmanagement.slave;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "상품리스트 상세정보 가져오기 REQ")
public class ProductDetailItemReqModel {
    
    @ApiModelProperty(notes = "Product ID", example = "1")
    private Integer p_prd_id;
    
}
