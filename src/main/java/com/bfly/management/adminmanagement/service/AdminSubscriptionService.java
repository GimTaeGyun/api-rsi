package com.bfly.management.adminmanagement.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.bfly.management.model.common.ApiResult;
import com.bfly.management.model.common.CommonCode;
import com.bfly.management.model.common.EnumMapperType;
import com.bfly.management.model.contractmanagement.master.CartUpdateReqModel;
import com.bfly.management.model.contractmanagement.slave.CartReqModel;

@Service
public class AdminSubscriptionService extends AdminBaseService{

    public ApiResult<?> setUser(CartUpdateReqModel param) throws Exception {
        
        
        Enum<? extends EnumMapperType> responseCode = null;

        HashMap<String, Object> result = null;
        ArrayList<Object> resultArray = new ArrayList<Object>();

        HashMap<String, Object> callParameter = new HashMap<String, Object>();

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

}
