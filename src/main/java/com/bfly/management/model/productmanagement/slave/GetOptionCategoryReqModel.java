package com.bfly.management.model.productmanagement.slave;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "옵션카테고리 가져오기 REQ")
public class GetOptionCategoryReqModel {
    
    @ApiModelProperty(notes = "OptionCategory ID", example = "0")
    private Integer p_opt_cat_id;
}
