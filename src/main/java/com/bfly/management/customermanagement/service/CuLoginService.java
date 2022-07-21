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
public class CuLoginService extends BaseService{

    public ObjectMapper objectMapper = new ObjectMapper();

    public BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
    @Autowired
    KeycloakService keycloakService;

	public ApiResult<HashMap<String, Object>> customerLogin(LoginReqModel param) throws Exception
	{

		Enum<? extends EnumMapperType> responseCode = null;

        HashMap<String, Object> result = null;

		HashMap<String, Object> loginMap = new HashMap<>();

		// 아이디, 패스워드 공백 체크
		if(param.getUsrId() == null || "".equals(param.getUsrId())){
			return new ApiResult<HashMap<String, Object>>(CommonCode.COMMON_LOGIN_NOT_VALID_ID_PASSWORD, null);
		}

		if(param.getUsrPw() == null || "".equals(param.getUsrPw())){
			return new ApiResult<HashMap<String, Object>>(CommonCode.COMMON_LOGIN_NOT_VALID_ID_PASSWORD, null);
		}

		result = this.slaveMapper.selectLogin(param.getUsrId());

		if( null == result ){ // 아이디에 대한 정보 가 없을시
			return new ApiResult<HashMap<String, Object>>(CommonCode.COMMON_LOGIN_NOT_VALID_ID_PASSWORD, null);
		}else{
			// Password 확인
			if (!passwordEncoder.matches(param.getUsrPw(), (String)result.get("login_pw")))
			{
				return new ApiResult<HashMap<String, Object>>(CommonCode.COMMON_LOGIN_NOT_VALID_ID_PASSWORD, null);
			}

			// token 인증 추가 필요
			HashMap<String, Object> resultToken = keycloakService.GenerateToken();

			loginMap.put("returnMsg", "OK");
			loginMap.put("custId", result.get("cust_id"));
			loginMap.put("custNm", result.get("cust_nm"));
			loginMap.put("custStatus", result.get("status"));
			loginMap.put("accessToken", resultToken.get("access_token"));
			loginMap.put("refreshToken", resultToken.get("refresh_token"));

			responseCode = CommonCode.COMMON_SUCCESS;
		}

		return new ApiResult<HashMap<String, Object>>(responseCode, loginMap);

	}

}
