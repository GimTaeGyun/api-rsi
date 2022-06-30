package com.bfly.management.model.productmanagement.master;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductGroupModel {
    
    @ApiModelProperty(notes = "상품그룹ID, 추가 경우 null, 수정/삭제시 대항 id") 
    private Integer prdGrpId;

    @ApiModelProperty(notes = "서비스ID", example = "1", required = true) 
    private Integer sid;

    @ApiModelProperty(notes = "상품 그룹명", example = "테스트상품그룹1", required = true) 
    private String prdGrpNm;

    @ApiModelProperty(notes = "정렬값", example = "1", required = true) 
    private Integer sort;

    @ApiModelProperty(notes = "상위그룹ID", example = "1", required = true) 
    private Integer uppPrdGrpId;

    @ApiModelProperty(notes = "상품그룹 상세설명", example = "상품그룹상세 설명") 
    private String description;    
}
