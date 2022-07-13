package com.bfly.management.model.productmanagement.master;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PromotionModel {
    
    @ApiModelProperty(notes = "약관부가정보(프로모션 동의 등)") 
    private PromotionDetailModel promotion;

}
