package com.bfly.management.model.customermanagement.slave;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDetailListModel {
    
    @ApiModelProperty
    (notes = "고객 번호" ,example = "232e9b0a3bb22717c5e54ae9df67219e", required = true) 
    private String cust_id;

}
