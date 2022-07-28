package com.bfly.management.model.customermanagement.slave;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerListModel {
    
    @ApiModelProperty
    (notes = "한 페이지에 들어갈 행 수" ,example = "5", required = true) 
    private String page;

    @ApiModelProperty
    (notes = "페이지 번호", example = "2", required = true) 
    private String page_no;

}
