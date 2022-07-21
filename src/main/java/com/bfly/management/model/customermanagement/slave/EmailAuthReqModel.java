package com.bfly.management.model.customermanagement.slave;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailAuthReqModel {
    
    @ApiModelProperty(notes = "Email 주소", example = "bflysoft@bflysoft.com", required = true) 
    private String email;
}
