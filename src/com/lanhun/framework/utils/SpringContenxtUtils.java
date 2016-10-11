package com.lanhun.framework.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/**
 * spring mvc context utils/operate servlet 
 * @author Administrator
 *
 */
public class SpringContenxtUtils {

	/**
	 * 
	 * @return
	 */
	private static RequestAttributes getRequestAttributes() {
		return RequestContextHolder.getRequestAttributes();
	}

	/**
	 * 
	 * @return
	 */
	private static ServletRequestAttributes getServletRequestAttributes() {
		return (ServletRequestAttributes) getRequestAttributes();
	}
	


	/**
	 * 
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		return getServletRequestAttributes().getRequest();
	}
	/**
	 * 
	 * @return
	 */
	public static HttpSession getSession(){
		return getRequest().getSession();
	}
	@SuppressWarnings("unchecked")
	public static <T> T getSessionValue(String name){
		return (T)getSession().getAttribute(name);
	}
}
