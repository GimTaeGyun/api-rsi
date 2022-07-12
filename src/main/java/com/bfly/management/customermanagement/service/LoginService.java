package com.bfly.management.customermanagement.service;
import java.util.HashMap;

import com.bfly.management.model.common.ApiResult;
import com.bfly.management.model.common.CommonCode;
import com.bfly.management.model.common.EnumMapperType;
import com.bfly.management.model.customermanagement.slave.LoginReqModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class LoginService extends BaseService{

    public ObjectMapper objectMapper = new ObjectMapper();

    public BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public ApiResult<HashMap<String, Object>> login(LoginReqModel param) throws Exception
	{

		Enum<? extends EnumMapperType> responseCode = null;

        HashMap<String, Object> result = null;

		HashMap<String, Object> loginMap = new HashMap<>();

		HashMap<String, Object> callParameter = new HashMap<String, Object>();

		// callParameter.put("p_id", objectMapper.writeValueAsString(param));
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
		}

		int rc = (int)result.get("p_rc");
        if (result == null || rc == 255 ) {
            responseCode = CommonCode.COMMON_FAIL;
        }else{
            responseCode = CommonCode.COMMON_SUCCESS;
        }

		return new ApiResult<HashMap<String, Object>>(CommonCode.COMMON_SUCCESS, loginMap);

	}

	// @Autowired
	// private AuthConnectionUtil authConnectionUtil;

	/**
	 * 로그인
	 * @param param
	 * @return
	 * @throws Exception
	 */
    // public ApiResult<HashMap<String, Object>> login(LoginReqModel param) throws Exception
    // {
    //     HashMap<String, Object> loginMap = new HashMap<>();

    //     String loginResult = this.slaveMonitoringMapper.selectLogin(param.getUsrId());

	// 	if( null == loginResult ){ // 아이디에 대한 정보 가 없을시
	// 		return new ApiResult<HashMap<String, Object>>(CommonCode.COMMON_LOGIN_NOT_VALID_ID_PASSWORD, null);
	// 	}else{
	// 		loginMap = objectMapper.readValue(loginResult, HashMap.class);
			
	// 		// Password 확인
	// 		if (!passwordEncoder.matches(param.getUsrPw(), (String)loginMap.get("pw")))
	// 		{
	// 			return new ApiResult<HashMap<String, Object>>(CommonCode.COMMON_LOGIN_NOT_VALID_ID_PASSWORD, null);
	// 		}
	// 		loginMap.remove("pw"); // 더이상 사용하지 않는 필드 삭제
	// 		int ctrtNo = (int)loginMap.get("ctrtNo"); // 계약 넘버 확인

	// 		if ( 0 == ctrtNo ) // 계약이 0 일시
	// 		{
	// 			return new ApiResult<HashMap<String, Object>>(CommonCode.COMMON_LOGIN_NOT_VALID_CTRT, null);
	// 		}
	// 	}

	// 	// APIToeknResModel tokenInfo = monitoringSlaveService.getTokenInfo(param.getUsrId(), "");
	// 	APIToeknResModel tokenInfo = getTokenInfo(param.getUsrId(), "");

	// 	loginMap.put("token", tokenInfo.getAccess_token());
	// 	loginMap.put("refreshToken", tokenInfo.getRefresh_token());
		
    //     return new ApiResult<HashMap<String, Object>>(CommonCode.COMMON_SUCCESS, loginMap);
        
    // }

		/**
	 *
	 * @작성자 : sin1226
	 * @작성일 : 2021. 4. 30.
	 * @Method Name : getTokenInfo
	 * @return : APIToeknResModel
	 * @Method 설명 : 토큰정보 가져오기
	 * @return
	 * @throws Exception
	 */
	// public APIToeknResModel getTokenInfo(String usrId, String clientIP) throws Exception {

	// 	APIToeknResModel tokenInfo = null;

	// 	try {
	// 		tokenInfo = authConnectionUtil.getToken(usrId, clientIP);
	// 		return tokenInfo;
	// 	} catch (Exception e) {
	// 		log.error("토큰생성 오류", e);
	// 		throw new BusinessException(ApiCode.API_TOKEN_CREATE_FAIL);
	// 	}
	// }

    
}
