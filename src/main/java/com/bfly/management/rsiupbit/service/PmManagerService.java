package com.bfly.management.rsiupbit.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.bfly.management.model.common.ApiResult;
import com.bfly.management.model.common.CommonCode;
import com.bfly.management.model.common.EnumMapperType;
import com.bfly.management.model.productmanagement.master.OptionCategoryUpdateReqModel;
import com.bfly.management.model.productmanagement.master.OptionProductUpdateReqModel;
import com.bfly.management.model.productmanagement.master.ProductGroupUpdateReqModel;
import com.bfly.management.model.productmanagement.master.ProductModel;
import com.bfly.management.model.productmanagement.master.ProductUpdateReqModel;
import com.bfly.management.model.productmanagement.slave.GetOptionCategoryReqModel;
import com.bfly.management.model.productmanagement.slave.ProductItemReqModel;

import java.lang.SuppressWarnings;

@Service
@SuppressWarnings("unchecked")
public class PmManagerService extends ProductBaseService{

    public ApiResult<?> getProduct() throws Exception {
        
        ArrayList<HashMap> result = null;
        // String result = null;
        Enum<? extends EnumMapperType> responseCode = null;
        ArrayList<Object> resultArray = new ArrayList<Object>();

        // result = this.slaveMapper.getProduct();?
        result = this.slaveMapper.selectCoin();
        if (result == null) {
            responseCode = CommonCode.COMMON_FAIL;
        }else{
            // resultArray = objectMapper.readValue(result, ArrayList.class);
            responseCode = CommonCode.COMMON_SUCCESS;
        }
        

        return new ApiResult<Object>(responseCode, resultArray);
    }

}
