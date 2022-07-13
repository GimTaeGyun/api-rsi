package com.bfly.management.model.customermanagement.master;

import com.bfly.management.model.productmanagement.master.PromotionModel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerInfoModel {
    
    @ApiModelProperty(notes = "계약담당자명 (개인고객일 경우 고객명)", example = "안동시청", required = true) 
    private String custNm;

    @ApiModelProperty(notes = "계약담당자 이메일주소 (개인고객일 경우 고객이메일)", example = "yh.jang@andong.kr", required = true) 
    private String email;

    @ApiModelProperty(notes = "계약담당자 휴대폰 전화번호 (개인고객일 경우 고객휴대폰번호)", example = "010-9486-8564", required = true)
    private String mobile;

    @ApiModelProperty(notes = "구독페이지 로그인 아이디", example = "andong", required = true)
    private String loginId;

    @ApiModelProperty(notes = "구독페이지 로그인 비밀번호", example = "$2a$10$gorZIr92Iy5esdy0Q24", required = true)
    private String loginPw;

    @ApiModelProperty(notes = "고객유형 (1:법인, 2:공공, 3:개인)  *필수", example = "2", required = true)
    private int custTp;	

    @ApiModelProperty(notes = "계약담당자 부서명  *필수(법인, 공공기관일때만)", example = "공보감사실")
    private String deptNm;	

    @ApiModelProperty(notes = "회사 우편번호 *필수(법인, 공공기관일때만)", example = "36691")
    private String postNo;	

    @ApiModelProperty(notes = "회사주소  *필수(법인, 공공기관일때만)", example = "경북 안동시 퇴계로 115 (명륜동)")
    private String address;	
    
    @ApiModelProperty(notes = "개인정보 유효기관 (탈퇴시부터 일자로 관리)  *필수", example = "365", required = true)
    private int piStoreDays;	
    
    @ApiModelProperty(notes = "회사명  *필수(법인, 공공기관일때만)", example = "안동시청")
    private String cpyNm;

    @ApiModelProperty(notes = "사업자등록번호  *필수(법인, 공공기관일때만)", example = "508-83-00017")
    private String corpRegNo;		

    @ApiModelProperty(notes = "대표자명  *필수(법인, 공공기관일때만)", example = "윤석열")
    private String ceo;			

    @ApiModelProperty(notes = "기업유형 (CORP:법인, PUBL:공공기관)  *필수(법인, 공공기관일때만)", example = "PUBL")
    private String corpTp;	

    @ApiModelProperty(notes = "기업규모 (1:대기업, 2:중견기업, 3:중소기업, 4: 소기업, 5:소상공인)", example = "0")
    private int corpSize;		
    
    @ApiModelProperty(notes = "직원규모 (1:3천명이상, 2: 2천명이상~3천명미만, 3: 1천명이상~2천명미만, 4:5백명이상~1천명미만, 5:1백명이상~5백명미만,6:1백명미만)", example = "1")
    private int empSize;		

    @ApiModelProperty(notes = "사업자등록증경로", example = "upload")
    private String corpRegPath;		

    @ApiModelProperty(notes = "약관번호  *필수", example = "1", required = true)
    private String tosNo;	
    
    @ApiModelProperty(notes = "약관동의여부(true:동의, false:미동의)  *필수", example = "true", required = true)
    private boolean tosIsAgree;									

    @ApiModelProperty(notes = "약관부가정보(프로모션 동의 등)")
    private PromotionModel tosInfo;						

}
