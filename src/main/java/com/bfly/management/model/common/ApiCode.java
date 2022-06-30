package com.bfly.management.model.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ApiCode implements EnumMapperType {
	// 1000 ~ 1999
	API_TOKEN_CREATE_FAIL("1000", "토큰생성에 실패하였습니다."),
	API_WIDGET_MENUID_EMPTY_FAIL("1001", "메뉴명은 필수값입니다."),
	API_PARAMETER_EMPTY_FAIL("1002", "파리미터값이 없습니다."),
	API_TENANT_ID_EMPTY_FAIL("1003", "테넌트ID값이 없습니다."),
	API_TENANT_WORKGROUP_NOT_EXIST_FAIL("1004", "워크그룹이 존재하지 않습니다."),
	API_USERID_EMPTY_FAIL("1005", "사용자ID가 없습니다."),
	API_TENANT_WORKGROUPID_EMPTY_FAIL("1006", "워크그룹ID가 없습니다."),
	API_SORT_EMPTY_FAIL("1007", "정렬순서가 없습니다."),
	API_TENANT_WORKBOARDID_EMPTY_FAIL("1008", "워크보드ID가 없습니다."),
	API_TENANT_WORKGBOARD_NOT_EXIST_FAIL("1009", "워크보드가 존재하지 않습니다."),
	API_TENANT_WORKGROUP_NAME_NOT_EXIST_FAIL("1010", "워크그룹명이 없습니다."),
	API_TENANT_WORKBOARD_NAME_NOT_EXIST_FAIL("1011", "워크보드명이 없습니다."),
	API_WIDGET_INFO_NOT_EXIST_FAIL("1012", "위젯정보가 없습니다."),
	API_WIDGET_LAYOUT_INFO_NOT_EXIST_FAIL("1013", "위젯레이아웃 정보가 없습니다."),
	API_WIDGET_KWD_CNT_ONLY_ONE_FAIL("1014", "해당위젯은 키워드 갯수가 1개입니다."),
	API_WIDGET_KWD_CNT_ONE_MORE_EXIST_FAIL("1015", "해당위젯은 키워드 갯수가 1개이상 입니다."),
	API_USER_GROUP_NOT_ADMIN_FAIL("1016", "해당ID는 관리자 권한이 없습니다."),
	API_USER_NOT_VALID_FAIL("1017", "유효하지않는 사용자입니다."),
	API_USER_GROUP_NOT_VALID_FAIL("1018", "유효하지않는 사용자그룹입니다."),
	API_USER_OR_GROUP_NOT_VALID_FAIL("1019", "유효하지않는 사용자ID 또는 사용자그룹입니다."),
	API_USER_ID_DUPLICATION_FAIL("1020", "중복된 사용자ID입니다."),
	API_USER_ID_EMPTY_FAIL("1021", "사용자ID 목록이 없습니다."),
	API_USER_GROUP_SORT_NOT_VALID_FAIL("1022", "변경순번값이 유효하지 않습니다."),
	API_WIDGET_TEMPLATE_NOT_MODIFY("1023", "템플릿 위젯은 수정할 수 없습니다."),
	API_TENANT_WORKGROUP_ONE_MORE_FAIL("1024", "워크그룹은 최소 2개 이상일때만 삭제하실 수 있습니다."),
	API_TENANT_WORKGBOARD_ONE_MORE_FAIL("1025", "워크보드는 최소 2개 이상일때만 삭제하실 수 있습니다."),
	API_NOTICE_CONFIG_SAVE_FAIL("1026", "알림설정 저장에 실패하였습니다."),
	API_NOTICE_CONFIG_ID_EXISTS_FAIL("1027", "기존 알림설정ID 값이 있습니다."),
	API_NOTICE_CONFIG_ID_NOT_MATCH_FAIL("1028", "기존 알림설정ID값과 다릅니다."),
	API_NOTICE_CONTACT_DUPLE_FAIL("1029", "동일한 연락처가 있습니다."),
	API_NOTICE_CONFIG_TIME_CHECK_FALI("1029", "시간지정일 경우 시작시간과 끝시간이 필요합니다."),

	API_ELASTIC_CONNECTION_FAIL("1100", "검색엔진 연결에 문제가 있습니다."),
	API_ELASTIC_SEARCH_STARTDATE_EMPTY_FAIL("1101", "시작일은 필수값입니다."),
	API_ELASTIC_SEARCH_ENDDATE__EMPTY_FAIL("1102", "종료일은 필수값입니다."),
	API_ELASTIC_SEARCH_KWD_EMPTY_FAIL("1103", "키워드는 필수값입니다."),
	API_ELASTIC_SEARCH_COLCH_EMPTY_FAIL("1104", "채널은 필수값입니다."),
	API_ELASTIC_SEARCH_WGID_EMPTY_FAIL("1105", "위젯ID은 필수값입니다."),
	API_ELASTIC_SEARCH_WGTP_MATCH_FAIL("1106", "현재위젯에서는 해당위젯타입을 사용할수 없습니다."),
	;

	private String code;
	private String msg;

	ApiCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getMsg() {
		return msg;
	}
}
