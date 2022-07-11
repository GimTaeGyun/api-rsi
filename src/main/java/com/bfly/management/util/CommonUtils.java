package com.bfly.management.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {

	public static String inputstreamToString(InputStream is) throws Exception{
		StringBuilder textBuilder = new StringBuilder();
        try (Reader reader = new BufferedReader(new InputStreamReader
          (is, Charset.forName(StandardCharsets.UTF_8.name())))) {
            int c = 0;
            while ((c = reader.read()) != -1) {
                textBuilder.append((char) c);
            }
        }

		return textBuilder.toString();
	}

	public static String isValidPassword(String password) throws Exception {
		
		// 최소 8자, 최대 20자 상수 선언
		final int MIN = 8;
		final int MAX = 20;

		// 영어, 숫자, 특수문자 포함한 MIN to MAX 글자 정규식
		final String REGEX = "^((?=.*\\d)(?=.*[a-zA-Z])(?=.*[\\W]).{" + MIN + "," + MAX + "})$";
		
		// 3자리 연속 문자 정규식
		//final String SAMEPT = "(\\w)\\1\\1";
		
		// 공백 문자 정규식
		final String BLANKPT = "(\\s)";

		// 정규식 검사객체
		Matcher matcher;

		// 공백 체크
		if (password == null || "".equals(password)) {
			return "비밀번호가 없습니다.";
		}

		// ASCII 문자 비교를 위한 UpperCase
		String tmpPw = password.toUpperCase();
		// 문자열 길이
		int strLen = tmpPw.length();

		// 글자 길이 체크
		if (strLen > 20 || strLen < 8) {
			return "비밀번호 길이는 8~16자리 사이입니다.(길이: " + strLen + ")";
		}

		// 공백 체크
		matcher = Pattern.compile(BLANKPT).matcher(tmpPw);
		if (matcher.find()) {
			return "비밀번호에 빈칸이 있습니다.";
		}

		// 비밀번호 정규식 체크
		matcher = Pattern.compile(REGEX).matcher(tmpPw);
		if (!matcher.find()) {
			return "비밀번호는 영문,숫자,특수문자를 조합하여 8~16자리로 설정해주세요.";
		}

		return "success";
	}
	
	public static List<Integer> getBitVal(int val) {
		List<Integer> result = new ArrayList<>();
		int stdVal = val;
		int runCnt = (int) Math.ceil(Math.sqrt(val));
		
		if(stdVal == 1) {
			result.add(1);
			return result;
		}
		
		for (int i = runCnt; i > 0; i--) {
			int powNum = (int) Math.pow(2, i);
			
			if(stdVal < powNum) continue;
			stdVal -= powNum;
			
			result.add(i + 1);
			if(stdVal == 1) result.add(1);
		}
		
		Collections.sort(result);
		return result;
	}
	
	public static int sumBitVal(List<Integer> val) {
		int result = 0;
		
		for (Integer i : val) {
			int powNum = (int) Math.pow(2, i - 1);
			result += powNum;
		}

		return result;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> convertObjectToList(Object obj) {
	    List<T> list = new ArrayList<>();
	    if (obj.getClass().isArray()) {
	    	list = Arrays.asList((T[])obj);
	    } else if (obj instanceof Collection) {
	        list = new ArrayList<>((Collection<T>)obj);
	    }
	    return list;
	}
	
	public static boolean isCollection(Object obj) {
		return obj.getClass().isArray() || obj instanceof Collection;
	}
	
	public static boolean isTel(String tel) {
		return tel.matches("(01[016789])(\\d{3,4})(\\d{4})");
	}
}
