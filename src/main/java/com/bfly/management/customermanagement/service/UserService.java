package com.bfly.management.customermanagement.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bfly.management.model.common.ApiResult;
import com.bfly.management.model.common.CommonCode;
import com.bfly.management.model.common.EnumMapperType;

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

    public ApiResult<?> passwordEncrypt(String param){
        
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        return new ApiResult<>(CommonCode.COMMON_SUCCESS, passwordEncoder.encode(param));
    }

}
