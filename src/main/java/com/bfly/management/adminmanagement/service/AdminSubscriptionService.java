package com.bfly.management.adminmanagement.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bfly.management.model.adminmanagement.master.UserChangePwReqModel;
import com.bfly.management.model.adminmanagement.master.UserDeleteReqModel;
import com.bfly.management.model.adminmanagement.master.UserUpdateReqModel;
import com.bfly.management.model.adminmanagement.slave.UserReqModel;
import com.bfly.management.model.common.ApiResult;
import com.bfly.management.model.common.CommonCode;
import com.bfly.management.model.common.EnumMapperType;

@Service
public class AdminSubscriptionService extends AdminBaseService{

    public BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ApiResult<?> setUser(UserUpdateReqModel param) throws Exception {
        
        
        Enum<? extends EnumMapperType> responseCode = null;

        HashMap<String, Object> result = null;
        ArrayList<Object> resultArray = new ArrayList<Object>();

        HashMap<String, Object> callParameter = new HashMap<String, Object>();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        param.setUsrPw(passwordEncoder.encode(param.getUsrPw()));

        callParameter.put("p_params", objectMapper.writeValueAsString(param));
        callParameter.put("p_rc",0);
        callParameter.put("p_rm", "OK");
        
        result = this.masterMapper.setUser(callParameter);
        
        int rc = (int)result.get("p_rc");
        if (result == null || rc == 255 ) {
            responseCode = CommonCode.COMMON_FAIL;
        }else{
            responseCode = CommonCode.COMMON_SUCCESS;
        }

        return new ApiResult<Object>(responseCode, resultArray);
    }

    public ApiResult<?> delUser(UserDeleteReqModel param) throws Exception {
        
        
        Enum<? extends EnumMapperType> responseCode = null;

        HashMap<String, Object> result = null;
        ArrayList<Object> resultArray = new ArrayList<Object>();

        HashMap<String, Object> callParameter = new HashMap<String, Object>();

        callParameter.put("p_params", objectMapper.writeValueAsString(param));
        callParameter.put("p_rc",0);
        callParameter.put("p_rm", "OK");
        
        result = this.masterMapper.delUser(callParameter);
        
        int rc = (int)result.get("p_rc");
        if (result == null || rc == 255 ) {
            responseCode = CommonCode.COMMON_FAIL;
        }else{
            responseCode = CommonCode.COMMON_SUCCESS;
        }

        return new ApiResult<Object>(responseCode, resultArray);
    }

    public ApiResult<?> selectUser(UserReqModel param) throws Exception {
        
        String result = null;
        Enum<? extends EnumMapperType> responseCode = null;
        ArrayList<Object> resultArray = new ArrayList<Object>();

        
		HashMap<String, Object> callParameter = new HashMap<String, Object>();

		callParameter.put("p_usrId", param.getUsrId());
        callParameter.put("p_usrName",param.getUsrNm());
        callParameter.put("p_status", param.getStatus());

        result = this.slaveMapper.selectUser(callParameter);
        
        if (result == null) {
            responseCode = CommonCode.COMMON_FAIL;
        }else{
            resultArray = objectMapper.readValue(result, ArrayList.class);
            responseCode = CommonCode.COMMON_SUCCESS;
        }
        
        return new ApiResult<Object>(responseCode, resultArray);
    }

    public ApiResult<?> changeUserPw(UserChangePwReqModel param) throws Exception {
        
        Enum<? extends EnumMapperType> responseCode = null;
        
		HashMap<String, Object> callParameter = new HashMap<String, Object>();

		callParameter.put("p_usrId", param.getUsrId());

        param.setUsrPw(passwordEncoder.encode(param.getUsrPw()));

		callParameter.put("p_usrPw", param.getUsrPw());

        int cnt = this.masterMapper.updateUserPw(callParameter);

        if (cnt > 0) {
            responseCode = CommonCode.COMMON_SUCCESS;
        } else {
            responseCode = CommonCode.COMMON_FAIL;
        }
        
        return new ApiResult<Object>(responseCode, null);
    }

}
