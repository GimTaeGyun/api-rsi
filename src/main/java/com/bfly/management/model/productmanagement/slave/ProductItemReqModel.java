package com.bfly.management.model.productmanagement.slave;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "상품가져오기 REQ")
public class ProductItemReqModel {

	@ApiModelProperty(notes = "서비스ID", example = "1", required = true) 
	private Integer sId;
}
