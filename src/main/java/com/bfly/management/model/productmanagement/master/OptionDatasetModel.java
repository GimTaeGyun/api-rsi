package com.bfly.management.model.productmanagement.master;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OptionDatasetModel {
    
    @ApiModelProperty(notes = "옵션카테고리ID, 추가 경우 null, 수정/삭제시 대상 id", example = "0") 
    private Integer optCatId;

    @ApiModelProperty(notes = "옵션카테고리명", example = "테스트상품옵션1", required = true) 
    private String optCatNm;

    @ApiModelProperty(notes = "정렬값", example = "1", required = true)  
    private Integer sort;

    @ApiModelProperty(notes = "옵션상위카테고리ID", example = "1", required = true)  
    private Integer uppOptCatId;

    @ApiModelProperty(notes = "옵션 상세설명", example = "동시접속사용자수") 
    private String description;

}
