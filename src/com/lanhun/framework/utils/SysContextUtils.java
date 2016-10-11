package com.lanhun.framework.utils;

import javax.servlet.http.HttpSession;

import com.lanhun.framework.orm.po.User;

public class SysContextUtils {
	public static User getCurrentUser(){
		HttpSession session=SpringContenxtUtils.getSession();
		return getCurrentUser(session);
	}
	public static  User getCurrentUser(HttpSession session) {
		User user = (User) session.getAttribute("CURRENT_lOGIN_USER");
		return user;
	}
	
	public static boolean hasLogin(HttpSession session){
		if(session==null){
			return false;
		}
		return getCurrentUser(session)!=null;
	}
	
	public static void  removeCurrentUser(HttpSession session) {
		session.removeAttribute("CURRENT_lOGIN_USER");
	}
	public static void logout(HttpSession session){
		removeCurrentUser(session);
		session.invalidate();
	}
	public static void logout(){
		logout(SpringContenxtUtils.getSession());
	}

}
