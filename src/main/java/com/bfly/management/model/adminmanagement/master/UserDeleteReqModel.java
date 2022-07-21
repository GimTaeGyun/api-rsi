package com.bfly.management.model.adminmanagement.master;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "사용자 삭제")
public class UserDeleteReqModel {

    @ApiModelProperty(notes = "사용자 아이디(여러명일 경우 ,로 구분)", example = "g8soft,test111", required = true) 
    private String usrId;

}
