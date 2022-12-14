package com.bfly.management.model.productmanagement.master;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OptionProductDatasetModel {
    
    @ApiModelProperty(notes = "옵션ID, 추가 경우 null, 수정/삭제시 대상 id", example = "0")
    private String optId;

    @ApiModelProperty(notes = "옵션명", example = "1", required = true) 
    private String optNm;

    @ApiModelProperty(notes = "옵션유형(WEIGHT: 가중치방식, DATE:날짜)", example = "WEIGHT", required = true) 
    private String optTp;

    @ApiModelProperty(notes = "옵션 연산자 단위(사칙연산부호(가중치 연산방식), 날짜단위(YEAR,MONTH,DAY...) 등)", example = "*", required = true) 
    private String operatorUnit;

    @ApiModelProperty(notes = "옵션카테고리ID", example = "2", required = true) 
    private String optCatId;

    @ApiModelProperty(notes = "정렬값", example = "1", required = true)  
    private Integer sort;

    @ApiModelProperty(notes = "옵션 상세설명", example = "동시접속사용자수") 
    private String description;

    @ApiModelProperty(notes = "옵션 아이템 리스트")
    private List<OptionItemModel> optItems;
}
