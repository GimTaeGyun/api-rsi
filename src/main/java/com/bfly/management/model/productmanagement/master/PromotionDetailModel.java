package com.bfly.management.model.productmanagement.master;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PromotionDetailModel {
    
    @ApiModelProperty(notes = "약관부가정보 이메일(프로모션 동의 등)", example = "true") 
    private String email;

    @ApiModelProperty(notes = "약관부가정보 모바일(프로모션 동의 등)", example = "true") 
    private String mobile;

}
