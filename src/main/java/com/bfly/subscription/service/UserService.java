package com.bfly.subscription.service;

import org.springframework.stereotype.Service;

import com.bfly.subscription.model.common.ApiResult;
import com.bfly.subscription.model.common.CommonCode;
import com.bfly.subscription.model.common.EnumMapperType;

@Service
public class UserService extends BaseService {
    
    public ApiResult<?> userLogin(String param){

        String result = null;
        Enum<? extends EnumMapperType> responseCode = null;

        result = this.slaveMapper.testQuery();
        responseCode = CommonCode.COMMON_SUCCESS;
        
        return new ApiResult<String>(responseCode, result);
    }

    public ApiResult<?> userJoin(String param){

        String result = null;
        Enum<? extends EnumMapperType> responseCode = null;

        result = this.slaveMapper.testQuery();
        responseCode = CommonCode.COMMON_SUCCESS;
        
        return new ApiResult<String>(responseCode, result);
    }

    public ApiResult<?> userInfo(String param){

        String result = null;
        Enum<? extends EnumMapperType> responseCode = null;

        result = this.slaveMapper.testQuery();
        responseCode = CommonCode.COMMON_SUCCESS;
        
        return new ApiResult<String>(responseCode, result);
    }
    
    public ApiResult<?> userUpdate(String param){

        String result = null;
        Enum<? extends EnumMapperType> responseCode = null;

        result = this.slaveMapper.testQuery();
        responseCode = CommonCode.COMMON_SUCCESS;
        
        return new ApiResult<String>(responseCode, result);
    }
    
    public ApiResult<?> findId(String param){

        String result = null;
        Enum<? extends EnumMapperType> responseCode = null;

        result = this.slaveMapper.testQuery();
        responseCode = CommonCode.COMMON_SUCCESS;
        
        return new ApiResult<String>(responseCode, result);
    }

    public ApiResult<?> findPassword(String param){

        String result = null;
        Enum<? extends EnumMapperType> responseCode = null;

        result = this.slaveMapper.testQuery();
        responseCode = CommonCode.COMMON_SUCCESS;
        
        return new ApiResult<String>(responseCode, result);
    }
    
    public ApiResult<?> resetPassword(String param){

        String result = null;
        Enum<? extends EnumMapperType> responseCode = null;

        result = this.slaveMapper.testQuery();
        responseCode = CommonCode.COMMON_SUCCESS;
        
        return new ApiResult<String>(responseCode, result);
    }

}
