package com.lanhun.framework.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class AuthorityFilter
 */
@WebFilter(description = "权限过滤器", urlPatterns = { "/*" })
public class AuthorityFilter implements Filter {
	private final static Logger logger=LoggerFactory.getLogger(AuthorityFilter.class);

   

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		logger.info("destroy");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//System.out.println(request);
		if(request instanceof HttpServletRequest){
		//	System.out.println("uri "+((HttpServletRequest) request).getRequestURI());
		//	System.out.println("url "+((HttpServletRequest) request).getRequestURL());
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		logger.info("init");
	}

}
