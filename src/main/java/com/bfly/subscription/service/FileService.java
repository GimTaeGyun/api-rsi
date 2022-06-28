package com.bfly.subscription.service;

import org.springframework.stereotype.Service;

import com.bfly.subscription.model.common.ApiResult;
import com.bfly.subscription.model.common.CommonCode;
import com.bfly.subscription.model.common.EnumMapperType;

@Service
public class FileService extends BaseService {

    public ApiResult<?> uploadLicense(String param){

        String result = null;
        Enum<? extends EnumMapperType> responseCode = null;

        result = this.slaveMapper.testQuery();
        responseCode = CommonCode.COMMON_SUCCESS;
        
        return new ApiResult<String>(responseCode, result);
    }
}
