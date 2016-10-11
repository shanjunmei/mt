package com.lanhun.framework.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lanhun.framework.utils.annotation.Permission;
import com.lanhun.framework.utils.annotation.PermissionType;

public class AuthorityInterceptor extends HandlerInterceptorAdapter {
	private final static Logger logger = LoggerFactory
			.getLogger(AuthorityInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)
			throws java.lang.Exception {
		boolean flag = super.preHandle(request, response, handler);

		if (handler instanceof HandlerMethod) {

			int ret = checkHasPermission((HandlerMethod) handler, request);
			if(ret==1){
				flag=true;
			}else{
				if(ret==2){
					flag=false;
					response.getWriter().append("no login");
					logger.info("request from :"+request.getRemoteAddr()+" no login");
					String contextPath=request.getContextPath();
					
					response.sendRedirect(contextPath+"/index.jsp");
					//request.getRequestDispatcher("index.jsp").forward(request, response);
				}else if(ret==3){
					flag=false;
					response.getWriter().append("no permission");
					logger.info("request from :"+request.getRemoteAddr()+" no permission");
					request.getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
				}
			}
		}

		
		return flag;
	}

	/**
	 * 
	 * @param handler
	 * @param request
	 * @return 1:sucess ,2 no login ,3 no permission
	 */
	private int checkHasPermission(HandlerMethod handler,
			HttpServletRequest request) {

		String beanName = handler.getBeanType().getSimpleName();
		String methodName = handler.getMethod().getName();

		int flag=2;
		
		logger.debug(beanName + "." + methodName);

		HttpSession session = request.getSession(false);
		//boolean flag = true;

		Permission permission = handler.getMethodAnnotation(Permission.class);
		if (permission != null) {
			if (PermissionType.NONE.equals(permission.type())) {
				//flag = true;
				flag=1;
			} else {
				if (session == null) {
					session=request.getSession();
					flag=2;
					//return false;
				} else {
					if (!SysContextUtils.hasLogin(session)) {
						flag=2;
						//return false;
					}else{
						flag=1;
					}
				}

				if (PermissionType.REQUIRED.equals(permission.type())) {

					// FIXME required check permission
					//flag = true;
					flag=1;
				} else if (PermissionType.OPTIONAL.equals(permission.type())) {

					// FIXME optional check permission
					flag = 1;
				}
			}
		} else {
			if (session == null) {
				session=request.getSession();
				flag=2;
			} else {
				if (!SysContextUtils.hasLogin(session)) {
					flag=2;
				}else{
					flag=1;
				}
			}
			// FIXME optional check permission
		}
		return flag;
	}
}
