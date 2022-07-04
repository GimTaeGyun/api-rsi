package com.bfly.management.productmanagement.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.bfly.management.model.common.ApiResult;
import com.bfly.management.model.common.CommonCode;
import com.bfly.management.model.common.EnumMapperType;
import com.bfly.management.model.productmanagement.slave.ProductDetailItemReqModel;



@Service
@SuppressWarnings("unchecked")
public class SubscriptionService extends ProductBaseService{ 

    public ApiResult<?> getProductDetail(ProductDetailItemReqModel param) throws Exception{

        String result = null;
        Enum<? extends EnumMapperType> responseCode = null;
        ArrayList<Object> resultArray = new ArrayList<Object>();

        result = this.slaveMapper.getProductDetail(param.getP_prd_id());
        if (result == null) {
            responseCode = CommonCode.COMMON_FAIL;
        }else{
            resultArray = objectMapper.readValue(result, ArrayList.class);
            responseCode = CommonCode.COMMON_SUCCESS;
        }

        return new ApiResult<Object>(responseCode, resultArray);
    }
}
