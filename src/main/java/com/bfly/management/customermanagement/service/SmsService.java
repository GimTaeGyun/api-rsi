package com.bfly.management.customermanagement.service;

import org.springframework.stereotype.Service;

import com.bfly.management.model.common.ApiResult;
import com.bfly.management.model.common.CommonCode;
import com.bfly.management.model.common.EnumMapperType;


@Service
public class SmsService extends BaseService {

    public ApiResult<?> userSmsCertified(String param){

        String result = null;
        Enum<? extends EnumMapperType> responseCode = null;

        result = this.slaveMapper.testQuery();
        responseCode = CommonCode.COMMON_SUCCESS;
        
        return new ApiResult<String>(responseCode, result);
    }
    
    public ApiResult<?> userSmsCertifiedCheck(String param){

        String result = null;
        Enum<? extends EnumMapperType> responseCode = null;

        result = this.slaveMapper.testQuery();
        responseCode = CommonCode.COMMON_SUCCESS;
        
        return new ApiResult<String>(responseCode, result);
    }
}
