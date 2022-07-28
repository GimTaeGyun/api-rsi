package com.bfly.management.customermanagement.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bfly.management.keycloakmanagement.service.KeycloakService;
import com.bfly.management.model.common.ApiResult;
import com.bfly.management.model.common.CommonCode;
import com.bfly.management.model.common.EnumMapperType;
import com.bfly.management.model.customermanagement.master.CustomerInfoModel;
import com.bfly.management.model.customermanagement.master.CustomerUserGroupModel;
import com.bfly.management.model.customermanagement.master.CustomerUserModel;
import com.bfly.management.model.customermanagement.slave.CustomerCheckModel;
import com.bfly.management.model.customermanagement.slave.CustomerDetailListModel;
import com.bfly.management.model.customermanagement.slave.CustomerListModel;
import com.bfly.management.model.keycloakmanagement.KeycloakCreateUserReqModel;

@Service
public class CuSubscriptionService extends BaseService{

    @Autowired
    KeycloakService keycloakService;

    public ApiResult<?> createCustomer(CustomerInfoModel param) throws Exception {

        // db transaction start
        this.masterMapper.startTransaction();

        Enum<? extends EnumMapperType> responseCode = null;
        HashMap<String, Object> result = null;            
        HashMap<String, Object> callParameter = new HashMap<String, Object>();

        KeycloakCreateUserReqModel keycloaParam = new KeycloakCreateUserReqModel();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        try {

            String rawPw = param.getLoginPw();

            param.setLoginPw(passwordEncoder.encode(param.getLoginPw()));

            callParameter.put("p_params", objectMapper.writeValueAsString(param));
            callParameter.put("p_rc",0);
            callParameter.put("p_rm", "OK");
            
            result = this.masterMapper.createCustomer(callParameter);
            
            int rc = (int) result.get("p_rc");
            if ( result == null || rc == 255 ) {
                responseCode = CommonCode.COMMON_FAIL;
            } else {                
                // keycloak 유저 생성
                keycloaParam.setUserId(param.getLoginId());
                keycloaParam.setUserPw(rawPw);
                keycloaParam.setUserNm(param.getCustNm());
                // keycloak email 중복 방지위해 공백으로 set
                keycloaParam.setEmail("");
                keycloaParam.setRoles(keycloaParam.getRoles().USER);
                keycloakService.createUser(keycloaParam);

                responseCode = CommonCode.COMMON_SUCCESS;
            }

        } catch (Exception e) {
            this.masterMapper.rollback();
            responseCode = CommonCode.COMMON_FAIL;
        }            

        this.masterMapper.commit();
        responseCode = CommonCode.COMMON_SUCCESS;

        return new ApiResult<Object>(responseCode, result);
    }

    public ApiResult<?> checkCustomer(CustomerCheckModel param) throws Exception {
        
        Enum<? extends EnumMapperType> responseCode = null;
        HashMap<String, Object> result = null;
        HashMap<String, Object> callParameter = new HashMap<String, Object>();

        callParameter.put("p_params", objectMapper.writeValueAsString(param));

        result = this.slaveMapper.checkCustomer(callParameter);

        int rc = (int) result.get("p_rc");
        if ( result == null || rc == 255 ) {
            responseCode = CommonCode.COMMON_FAIL;
        } else {
            responseCode = CommonCode.COMMON_SUCCESS;
        }

        return new ApiResult<Object>(responseCode, result);
    }

    public ApiResult<?> setCustUserGroup(CustomerUserGroupModel param) throws Exception {

        Enum<? extends EnumMapperType> responseCode = null;
        HashMap<String, Object> result = null;            
        HashMap<String, Object> callParameter = new HashMap<String, Object>();

        callParameter.put("p_params", objectMapper.writeValueAsString(param));
        callParameter.put("p_rc",0);
        callParameter.put("p_rm", "OK");
        
        result = this.masterMapper.setCustUserGroup(callParameter);
        
        int rc = (int) result.get("p_rc");
        if ( result == null || rc == 255 ) {
            responseCode = CommonCode.COMMON_FAIL;
        } else {                
            responseCode = CommonCode.COMMON_SUCCESS;
        }

        return new ApiResult<Object>(responseCode, result);
    }
    
    public ApiResult<?> setCustUser(CustomerUserModel param) throws Exception {

        Enum<? extends EnumMapperType> responseCode = null;
        HashMap<String, Object> result = null;            
        HashMap<String, Object> callParameter = new HashMap<String, Object>();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        param.setLoginPw(passwordEncoder.encode(param.getLoginPw()));

        callParameter.put("p_params", objectMapper.writeValueAsString(param));
        callParameter.put("p_rc",0);
        callParameter.put("p_rm", "OK");
        
        result = this.masterMapper.setCustUser(callParameter);
        
        int rc = (int) result.get("p_rc");
        if ( result == null || rc == 255 ) {
            responseCode = CommonCode.COMMON_FAIL;
        } else {                
            responseCode = CommonCode.COMMON_SUCCESS;
        }

        return new ApiResult<Object>(responseCode, result);
    }

    public ApiResult<?> selectCustList(CustomerListModel param) throws Exception {
        
        String result = null;
        Enum<? extends EnumMapperType> responseCode = null;
        ArrayList<Object> resultArray = new ArrayList<Object>();
		HashMap<String, Object> callParameter = new HashMap<String, Object>();

		callParameter.put("p_page", param.getPage());
        callParameter.put("p_page_no",param.getPage_no());

        result = this.slaveMapper.selectCustList(callParameter);
        
        if (result == null) {
            responseCode = CommonCode.COMMON_FAIL;
        } else {
            resultArray = objectMapper.readValue(result, ArrayList.class);
            responseCode = CommonCode.COMMON_SUCCESS;
        }
        
        return new ApiResult<Object>(responseCode, resultArray);
    }

    public ApiResult<?> selectCustDetailList(CustomerDetailListModel param) throws Exception {
        
        String result = null;
        Enum<? extends EnumMapperType> responseCode = null;
        ArrayList<Object> resultArray = new ArrayList<Object>();
		HashMap<String, Object> callParameter = new HashMap<String, Object>();

		callParameter.put("p_cust_id", param.getCust_id());

        result = this.slaveMapper.selectCustDetailList(callParameter);
        
        if (result == null) {
            responseCode = CommonCode.COMMON_FAIL;
        } else {
            resultArray = objectMapper.readValue(result, ArrayList.class);
            responseCode = CommonCode.COMMON_SUCCESS;
        }
        
        return new ApiResult<Object>(responseCode, resultArray);
    }
}
