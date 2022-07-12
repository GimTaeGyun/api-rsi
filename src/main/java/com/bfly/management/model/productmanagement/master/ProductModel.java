package com.bfly.management.model.productmanagement.master;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductModel {
    
    @ApiModelProperty(notes = "상품ID, 추가 경우 null, 수정/삭제시 대상 id", example = "0") 
    private String prdId;

    @ApiModelProperty(notes = "상품명", example = "(개인) 종판비신탁매체 전자스크랩") 
    private String prdNm;

    @ApiModelProperty(notes = "상품유형(WIDGET: 위젯, MEDIA:매체)", example = "MEDIA", required = true) 
    private String prdTp;

    @ApiModelProperty(notes = "상품군ID", example = "10", required = true) 
    private String prdGrpId;

    @ApiModelProperty(notes = "유효시작일", example = "1900-01-01 00:00:00", required = true) 
    private String vldBeginBt;

    @ApiModelProperty(notes = "유효만료일", example = "9999-12-31 00:00:00") 
    private String vldExpDt;    

    @ApiModelProperty(notes = "정렬값", example = "1") 
    private Integer sort;    

    @ApiModelProperty(notes = "상품설명", example = "상품 상세설명") 
    private String description;    

    @ApiModelProperty(notes = "상품상세", example = "상품 상세설명") 
    private String prdDetail;    

    private List<ProductItemModel> prdItems;
    
}
