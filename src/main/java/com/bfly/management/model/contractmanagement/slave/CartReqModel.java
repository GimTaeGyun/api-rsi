package com.bfly.management.model.contractmanagement.slave;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "장바구니 조회 REQ")
public class CartReqModel {
    
    @ApiModelProperty(notes = "고객 ID", example = "11494ff3b8d93df129ff10e5d30c6bd4", required = true)
    private String p_cust_id;
    
}
