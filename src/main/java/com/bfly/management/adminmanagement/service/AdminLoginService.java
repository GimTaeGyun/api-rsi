package com.bfly.management.adminmanagement.service;
import java.util.HashMap;

import com.bfly.management.keycloakmanagement.service.KeycloakService;
import com.bfly.management.model.adminmanagement.slave.AdminLoginReqModel;
import com.bfly.management.model.common.ApiResult;
import com.bfly.management.model.common.CommonCode;
import com.bfly.management.model.common.EnumMapperType;
import com.bfly.management.model.customermanagement.slave.LoginReqModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AdminLoginService extends AdminBaseService{

    public ObjectMapper objectMapper = new ObjectMapper();

    public BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
    @Autowired
    KeycloakService keycloakService;

	public ApiResult<HashMap<String, Object>> login(AdminLoginReqModel param) throws Exception
	{

		Enum<? extends EnumMapperType> responseCode = null;

        HashMap<String, Object> result = null;

		HashMap<String, Object> loginMap = new HashMap<>();

		HashMap<String, Object> callParameter = new HashMap<String, Object>();

		callParameter.put("p_id", param.getUsrId());
		// p_id 제외한 나머지 param 값은 상관없음, sp 형식 맞추기 위해 공백 값 넣어줌
        callParameter.put("p_rc",0);
        callParameter.put("p_rm", "OK");
		callParameter.put("p_pw", "");
		callParameter.put("p_usr_nm", "");
		callParameter.put("p_usr_tp", "");

		result = this.slaveMapper.selectAdminLogin(callParameter);

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
			
			loginMap.put("returnMsg", result.get("p_rm"));
			loginMap.put("usrNm", result.get("p_usr_nm"));
			loginMap.put("usrTp", result.get("p_usr_tp"));
			loginMap.put("accessToken", resultToken.get("access_token"));
			loginMap.put("refreshToken", resultToken.get("refresh_token"));
		}

		int rc = (int)result.get("p_rc");
        if (result == null || rc == 255 ) {
            responseCode = CommonCode.COMMON_FAIL;
        }else{
            responseCode = CommonCode.COMMON_SUCCESS;
        }

		return new ApiResult<HashMap<String, Object>>(responseCode, loginMap);

	}

}
