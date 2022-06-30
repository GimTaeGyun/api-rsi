package com.bfly.management.model.productmanagement.master;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OptionItemModel {


    @ApiModelProperty(notes = "옵션아이템명", example = "1User", required = true) 
    private String itemNm;

    @ApiModelProperty(notes = "옵션아이템값", example = "1.0", required = true) 
    private Double itemVal;

    @ApiModelProperty(notes = "정렬값", example = "1", required = true) 
    private String sort;

    @ApiModelProperty(notes = "옵션 상세설명", example = "단일 접속 사용자") 
    private String description;
}
