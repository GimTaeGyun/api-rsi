package com.bfly.management.model.customermanagement.slave;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailAuthCheckReqModel extends EmailAuthReqModel{
    
    @ApiModelProperty(notes = "Email 인증 번호", example = "123456", required = true)
    private String token;
}
