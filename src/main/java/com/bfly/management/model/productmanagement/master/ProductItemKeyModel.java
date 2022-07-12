package com.bfly.management.model.productmanagement.master;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductItemKeyModel {
    
    @ApiModelProperty(notes = "유효시작일", example = "mid") 
    private String name;

    @ApiModelProperty(notes = "유효만료일", example = "1598", required = true) 
    private String key;
}
