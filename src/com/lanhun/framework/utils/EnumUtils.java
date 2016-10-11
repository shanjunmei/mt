package com.lanhun.framework.utils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lanhun.framework.utils.em.EnumCode;
import com.lanhun.framework.utils.em.Status;
@SuppressWarnings("unchecked")
public class EnumUtils {
	private final static Logger logger = LoggerFactory.getLogger(EnumUtils.class);
	
	public static <K,V> Map<K, V> getEnumMap(Class<?> ec) {
		Map<K, V> emp = new HashMap<K, V>();
		if (ec.isEnum()) {
			Object[] ems=ec.getEnumConstants();
			try {
				Method name=ec.getMethod("getName");
				Method display=ec.getMethod("getDisplay");
				for (Object i : ems) {
					emp.put((K)name.invoke(i),(V) display.invoke(i));
				}
			} catch (java.lang.Exception e) {
				logger.warn(ec +" must implemption "+EnumCode.class);
			}
			
		}else{
			logger.warn(ec +" must extend enum ");
		}
		return emp;
	}

	public static void main(String[] args) {
		Map<String,Object> x = getEnumMap(Status.class);
		System.out.println(x);
	}
}
