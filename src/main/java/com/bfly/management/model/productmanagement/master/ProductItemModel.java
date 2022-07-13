package com.bfly.management.model.productmanagement.master;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductItemModel {
    
    @ApiModelProperty(notes = "상품아이템명", example = "경기일보", required = true) 
    private String itemNm;

    @ApiModelProperty(notes = "아이템유형", example = "MEDIA", required = true) 
    private String itemTp;

    @ApiModelProperty(notes = "기준단가", example = "60000.0", required = true) 
    private Double unitPrice;

    @ApiModelProperty(notes = "유효시작일", example = "1900-01-01 00:00:00", required = true) 
    private String vldBeginDt;

    @ApiModelProperty(notes = "유효만료일", example = "9999-12-31 00:00:00", required = true) 
    private String vldExpDt;    

    @ApiModelProperty(notes = "정렬값", example = "11", required = true) 
    private Integer sort;    

    @ApiModelProperty(notes = "아이템설명", example = "상품그룹상세 설명") 
    private String description;    

    @ApiModelProperty(notes = "아이템상세", example = "0") 
    private String itemDetail;    
}
