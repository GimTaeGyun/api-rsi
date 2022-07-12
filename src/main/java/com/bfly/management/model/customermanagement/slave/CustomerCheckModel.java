package com.bfly.management.model.customermanagement.slave;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCheckModel {
    
    @ApiModelProperty
    (notes = "체크항목(idCheck: 아이디 중복체크, findIdByPhone: 휴대폰 번호로 아이디 찾기, findIdByEmail: 이메일 주소로 아이디 찾기, findPwByPhone: 휴대폰번호로 비밀번호 찾기, findPwByEmail: 이메일주소로 비밀번호찾기, changePhoneNum: 휴대폰번호수정,changeEmail: 이메일 주소수정)"
    ,example = "findIdByPhone", required = true) 
    private String field;

    @ApiModelProperty
    (notes = "idCheck시 id값 입력, findIdByPhone/findIdByEmail시 이름, findPwByPhone/findPwByEmail시 아이디, changePhoneNum/changeEmail시 고객번호"
    , example = "안동시청", required = true) 
    private String value1;

    @ApiModelProperty
    (notes = "findIdByPhone/findPwByPhone시 휴대폰 번호, findIdByEmail/findPwByEmail시 이메일주소, changePhoneNum시 변경할 휴대폰번호, changeEmail시 변경할 이메일 주소"
    , example = "010-9486-8564", required = true)
    private String value2;	

}
