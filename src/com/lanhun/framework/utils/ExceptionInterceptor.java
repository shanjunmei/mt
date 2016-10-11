package com.lanhun.framework.utils;

import java.sql.SQLException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component 
public class ExceptionInterceptor {
	private static Logger logger = LoggerFactory
			.getLogger(ExceptionInterceptor.class);

	public void doAfter(JoinPoint jp) {
		//logger.info(jp.getTarget().getClass().getSimpleName()+"."+jp.getSignature().getName());
	}
	public void doThrowing(JoinPoint jp, java.lang.Throwable ex) throws Throwable{
		logger.debug(jp.getTarget().getClass().getSimpleName()+"."+jp.getSignature().getName());
		Throwable root= ExceptionUtils.getRootCause(ex);
		if(root instanceof SQLException){
			int errorCode=((SQLException) root).getErrorCode();
			String message=root.getMessage();
			String state=((SQLException) root).getSQLState();
			logger.info("SqlCode:"+errorCode+" , SqlState:"+state+" ,message:"+message);
			//throw new ServiceException("约束校验失败", ex);
		}
		throw ex;
		
	}
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable { 
		Object o=null;
		Object args[]=joinPoint.getArgs();
			long t=System.currentTimeMillis();
			try{
				o=joinPoint.proceed(args);
			}catch(Throwable e){
				t=System.currentTimeMillis()-t;
				logger.warn("invoke fail:"+joinPoint.getTarget().getClass().getSimpleName()+"."+joinPoint.getSignature().getName()+" take "+t+" ms");
				throw e;
			}
			t=System.currentTimeMillis()-t;
			logger.info("invoke success:"+joinPoint.getTarget().getClass().getSimpleName()+"."+joinPoint.getSignature().getName()+" take "+t+" ms");
		return o;
	}
}
