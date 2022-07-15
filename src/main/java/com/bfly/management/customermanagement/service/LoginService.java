package com.bfly.management.customermanagement.service;
import java.util.HashMap;

import com.bfly.management.keycloakmanagement.service.KeycloakService;
import com.bfly.management.model.common.ApiResult;
import com.bfly.management.model.common.CommonCode;
import com.bfly.management.model.common.EnumMapperType;
import com.bfly.management.model.customermanagement.slave.LoginReqModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class LoginService extends BaseService{

    public ObjectMapper objectMapper = new ObjectMapper();

    public BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
    @Autowired
    KeycloakService keycloakService;

	public ApiResult<HashMap<String, Object>> login(LoginReqModel param) throws Exception
	{

		Enum<? extends EnumMapperType> responseCode = null;

        HashMap<String, Object> result = null;

		HashMap<String, Object> loginMap = new HashMap<>();

		HashMap<String, Object> callParameter = new HashMap<String, Object>();

		callParameter.put("p_id", param.getUsrId());
        callParameter.put("p_rc",0);
        callParameter.put("p_rm", "OK");
		callParameter.put("p_pw", passwordEncoder.encode(param.getUsrPw()));
		callParameter.put("p_cust_id", param.getCust_id());
		callParameter.put("p_cust_nm", param.getCust_nm());

		result = this.slaveMapper.selectLogin(callParameter);

		if( null == result ){ // 아이디에 대한 정보 가 없을시
			return new ApiResult<HashMap<String, Object>>(CommonCode.COMMON_LOGIN_NOT_VALID_ID_PASSWORD, null);
		}else{
			// Password 확인
			if (!passwordEncoder.matches(param.getUsrPw(), (String)result.get("p_pw")))
			{
				return new ApiResult<HashMap<String, Object>>(CommonCode.COMMON_LOGIN_NOT_VALID_ID_PASSWORD, null);
			}

			// token 인증 추가 필요
			HashMap<String, Object> resultToken = keycloakService.GenerateToken();
			
			loginMap.put("accessToken", resultToken.get("access_token"));
			loginMap.put("refreshToken", resultToken.get("refresh_token"));
		}

		int rc = (int)result.get("p_rc");
        if (result == null || rc == 255 ) {
            responseCode = CommonCode.COMMON_FAIL;
        }else{
            responseCode = CommonCode.COMMON_SUCCESS;
        }

		return new ApiResult<HashMap<String, Object>>(CommonCode.COMMON_SUCCESS, loginMap);

	}

}
