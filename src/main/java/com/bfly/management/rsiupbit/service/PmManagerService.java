package com.bfly.management.rsiupbit.service;

import java.util.*;

import io.swagger.annotations.Api;
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

    public ApiResult<?> selectMenu() throws Exception {

        ArrayList<HashMap> resMenuId = null;

        // String result = null;
        Enum<? extends EnumMapperType> responseCode = null;
        ArrayList<Object> resultArray = new ArrayList<Object>();

        // result = this.slaveMapper.getProduct();?
//        resMenuId = this.slaveMapper.selectMenuId();
        resMenuId = this.slaveMapper.selectMenuByUpp(0);

        ArrayList<HashMap<String, Object>> resultArr = new ArrayList<HashMap<String, Object>>();

        for(HashMap hm : resMenuId){
            HashMap<String, Object> result = new HashMap<String, Object>();
            int menu_id = (int) hm.get("menu_id");
            String menu_nm = String.valueOf(hm.get("menu_nm"));
            System.out.println("menu_id:"+menu_id);
            result.put("menu_id", menu_id);
            result.put("menu_nm", menu_nm);
            ArrayList<HashMap> resSubMenu = this.slaveMapper.selectMenuByUpp(menu_id);
            result.put("subMenu", resSubMenu);

            resultArr.add(result);
        }

//        if (result == null) {
//            responseCode = CommonCode.COMMON_FAIL;
//        }else{
//            // resultArray = objectMapper.readValue(result, ArrayList.class);
//            responseCode = CommonCode.COMMON_SUCCESS;
//        }
        responseCode = CommonCode.COMMON_SUCCESS;

        return new ApiResult<Object>(responseCode, resultArr);
    };

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


        return new ApiResult<Object>(responseCode, result);
    }

}
