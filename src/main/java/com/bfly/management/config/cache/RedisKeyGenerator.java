package com.bfly.management.config.cache;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.util.StringUtils;

public class RedisKeyGenerator implements KeyGenerator {
	@Value("${spring.application.name}")
	public String appName;
	
	@Override
	public Object generate(Object target, Method method, Object... params) {
		String className = target.getClass().getSimpleName();
		String methodName = method.getName();
		String param = StringUtils.arrayToDelimitedString(params, "_");
		return appName +"_"+ className +"_"+ methodName+"_"+ param;
	}

}
