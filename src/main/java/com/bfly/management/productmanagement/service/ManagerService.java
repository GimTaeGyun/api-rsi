package com.bfly.management.productmanagement.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.bfly.management.model.common.ApiResult;
import com.bfly.management.model.common.CommonCode;
import com.bfly.management.model.common.EnumMapperType;
import com.bfly.management.model.productmanagement.master.OptionCategoryUpdateReqModel;
import com.bfly.management.model.productmanagement.master.ProductUpdateReqModel;
import com.bfly.management.model.productmanagement.slave.GetOptionCategoryReqModel;
import com.bfly.management.model.productmanagement.slave.ProductItemReqModel;

@Service
public class ManagerService extends ProductBaseService{

    public ApiResult<?> getProduct(ProductItemReqModel param) throws Exception {
        
        String result = null;
        Enum<? extends EnumMapperType> responseCode = null;
        ArrayList<Object> resultArray = new ArrayList<Object>();

        result = this.slaveMapper.getProduct(param.getSId());
        if (result == null) {
            responseCode = CommonCode.COMMON_FAIL;
        }else{
            resultArray = objectMapper.readValue(result, ArrayList.class);
            responseCode = CommonCode.COMMON_SUCCESS;
        }
        

        return new ApiResult<Object>(responseCode, resultArray);
    }

    public ApiResult<?> updateProduct(ProductUpdateReqModel param) throws Exception {
        
        HashMap<String, Object> result = null;
        Enum<? extends EnumMapperType> responseCode = null;
        ArrayList<Object> resultArray = new ArrayList<Object>();
        HashMap<String, Object> callParameter = new HashMap<String, Object>();

        callParameter.put("jsonParameter", objectMapper.writeValueAsString(param));
        callParameter.put("rc",0);
        callParameter.put("rm", "OK");

        result = this.masterMapper.setProduct(callParameter);
        int rc = (int)result.get("p_rc");
        if (result == null || rc == 255 ) {
            responseCode = CommonCode.COMMON_FAIL;
        }else{
            responseCode = CommonCode.COMMON_SUCCESS;
        }
        

        return new ApiResult<Object>(responseCode, resultArray);
    }



    public ApiResult<?> getOptionCategory(GetOptionCategoryReqModel param) throws Exception {
        
        String result = null;
        Enum<? extends EnumMapperType> responseCode = null;
        HashMap<String, Object> resultMap = new HashMap<String, Object>();

        result = this.slaveMapper.getOptionCategory(param.getP_opt_cat_id());
        if (result == null) {
            responseCode = CommonCode.COMMON_FAIL;
        }else{
            resultMap = objectMapper.readValue(result, HashMap.class);
            responseCode = CommonCode.COMMON_SUCCESS;
        }

        return new ApiResult<Object>(responseCode, resultMap);
    }

    public ApiResult<?> updateOptionCategory(OptionCategoryUpdateReqModel param) throws Exception {
        
        HashMap<String, Object> result = null;
        Enum<? extends EnumMapperType> responseCode = null;
        ArrayList<Object> resultArray = new ArrayList<Object>();
        HashMap<String, Object> callParameter = new HashMap<String, Object>();

        callParameter.put("jsonParameter", objectMapper.writeValueAsString(param));
        callParameter.put("rc",0);
        callParameter.put("rm", "OK");

        result = this.masterMapper.setOptionCategory(callParameter);
        int rc = (int)result.get("p_rc");
        if (result == null || rc == 255 ) {
            responseCode = CommonCode.COMMON_FAIL;
        }else{
            responseCode = CommonCode.COMMON_SUCCESS;
        }
        

        return new ApiResult<Object>(responseCode, resultArray);
    }
}
