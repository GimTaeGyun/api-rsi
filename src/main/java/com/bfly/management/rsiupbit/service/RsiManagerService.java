package com.bfly.management.rsiupbit.service;

import com.bfly.management.model.common.ApiResult;
import com.bfly.management.model.common.CommonCode;
import com.bfly.management.model.common.EnumMapperType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
@SuppressWarnings("unchecked")
public class RsiManagerService extends ProductBaseService{

    public ApiResult<?> selectRsi() throws Exception {

        ArrayList<HashMap> result = null;
        // String result = null;
        Enum<? extends EnumMapperType> responseCode = null;
        ArrayList<Object> resultArray = new ArrayList<Object>();

        // result = this.slaveMapper.getProduct();?
        result = this.rsiSlaveMapper.selectRsi();
        if (result == null) {
            responseCode = CommonCode.COMMON_FAIL;
        }else{
            // resultArray = objectMapper.readValue(result, ArrayList.class);
            responseCode = CommonCode.COMMON_SUCCESS;
        }


        return new ApiResult<Object>(responseCode, result);
    }

}
