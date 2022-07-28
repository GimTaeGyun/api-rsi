package com.bfly.management.adminmanagement.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bfly.management.model.adminmanagement.master.UserChangePwReqModel;
import com.bfly.management.model.adminmanagement.master.UserDelMoveReqModel;
import com.bfly.management.model.adminmanagement.master.UserUpdateReqModel;
import com.bfly.management.model.adminmanagement.slave.AdminCheckDupIdReqModel;
import com.bfly.management.model.adminmanagement.slave.MenuReqModel;
import com.bfly.management.model.adminmanagement.slave.UserGroupReqModel;
import com.bfly.management.model.adminmanagement.slave.UserGroupUpdateReqModel;
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
        HashMap<String, Object> callParameter = new HashMap<String, Object>();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        param.setUsrPw(passwordEncoder.encode(param.getUsrPw()));

        callParameter.put("p_params", objectMapper.writeValueAsString(param));
        callParameter.put("p_rc",0);
        callParameter.put("p_rm", "OK");
        
        result = this.masterMapper.setUser(callParameter);
        
        int rc = (int) result.get("p_rc");
        if ( result == null || rc == 255 ) {
            responseCode = CommonCode.COMMON_FAIL;
        } else {
            responseCode = CommonCode.COMMON_SUCCESS;
        }

        return new ApiResult<Object>(responseCode, result);
    }

    public ApiResult<?> delMoveUser(UserDelMoveReqModel param) throws Exception {
        
        Enum<? extends EnumMapperType> responseCode = null;
        HashMap<String, Object> result = null;
        HashMap<String, Object> callParameter = new HashMap<String, Object>();

        callParameter.put("p_params", objectMapper.writeValueAsString(param));
        callParameter.put("p_rc",0);
        callParameter.put("p_rm", "OK");
        
        result = this.masterMapper.delMoveUser(callParameter);
        
        int rc = (int) result.get("p_rc");
        if ( result == null || rc == 255 ) {
            responseCode = CommonCode.COMMON_FAIL;
        } else {
            responseCode = CommonCode.COMMON_SUCCESS;
        }

        return new ApiResult<Object>(responseCode, result);
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
        } else {
            resultArray = objectMapper.readValue(result, ArrayList.class);
            responseCode = CommonCode.COMMON_SUCCESS;
        }
        
        return new ApiResult<Object>(responseCode, resultArray);
    }

    public ApiResult<?> setUserGroup(UserGroupUpdateReqModel param) throws Exception {
        
        HashMap<String, Object> result = null;
        Enum<? extends EnumMapperType> responseCode = null;
        HashMap<String, Object> callParameter = new HashMap<String, Object>();

        callParameter.put("p_params", objectMapper.writeValueAsString(param));
        callParameter.put("p_rc",0);
        callParameter.put("p_rm", "OK");

        result = this.masterMapper.setUserGroup(callParameter);
        
        int rc = (int) result.get("p_rc");
        if ( result == null || rc == 255 ) {
            responseCode = CommonCode.COMMON_FAIL;
        } else {
            responseCode = CommonCode.COMMON_SUCCESS;
        }
        
        return new ApiResult<Object>(responseCode, result);
    }

    public ApiResult<?> changeUserPw(UserChangePwReqModel param) throws Exception {
        
        Enum<? extends EnumMapperType> responseCode = null;
		HashMap<String, Object> callParameter = new HashMap<String, Object>();

		callParameter.put("p_usrId", param.getUsrId());

        // password encoding
        param.setUsrPw(passwordEncoder.encode(param.getUsrPw()));
		callParameter.put("p_usrPw", param.getUsrPw());

        int cnt = this.masterMapper.updateUserPw(callParameter);

        if ( cnt > 0 ) {
            responseCode = CommonCode.COMMON_SUCCESS;
        } else {
            responseCode = CommonCode.COMMON_FAIL;
        }
        
        return new ApiResult<Object>(responseCode, null);
    }

    public ApiResult<?> selectMenu(MenuReqModel param) throws Exception {
        
        String result = null;
        Enum<? extends EnumMapperType> responseCode = null;
        ArrayList<Object> resultArray = new ArrayList<Object>();
		HashMap<String, Object> callParameter = new HashMap<String, Object>();
        
		callParameter.put("p_app_id", param.getAppId());
        callParameter.put("p_menu_id",param.getMenuId());
        callParameter.put("p_usr_id", param.getUsrId());

        result = this.slaveMapper.selectMenu(callParameter);
        
        if ( result == null ) {
            responseCode = CommonCode.COMMON_FAIL;
        } else {
            resultArray = objectMapper.readValue(result, ArrayList.class);
            responseCode = CommonCode.COMMON_SUCCESS;
        }
        
        return new ApiResult<Object>(responseCode, resultArray);
    }

    public ApiResult<?> selectUserGroup(UserGroupReqModel param) throws Exception {
        
        String result = null;
        Enum<? extends EnumMapperType> responseCode = null;
        HashMap<String, Object> resultArray = new HashMap<String, Object>();

        result = this.slaveMapper.selectUserGroup(Integer.parseInt(param.getUsr_grp_id()));
        
        if ( result == null ) {
            responseCode = CommonCode.COMMON_FAIL;
        } else {
            resultArray = objectMapper.readValue(result, HashMap.class);
            responseCode = CommonCode.COMMON_SUCCESS;
        }
        
        return new ApiResult<Object>(responseCode, resultArray);
    }

    public ApiResult<?> checkDupId(AdminCheckDupIdReqModel param) throws Exception {
        
        int result = 0;
        Enum<? extends EnumMapperType> responseCode = null;

        result = this.slaveMapper.checkDupId(param.getUsrId());
        
        // 0보다 크면 중복 아이디 존재
        if (result > 0) {
            responseCode = CommonCode.COMMON_FAIL;
        } else {
            responseCode = CommonCode.COMMON_SUCCESS;
        }
        
        return new ApiResult<Object>(responseCode, null);
    }
}
