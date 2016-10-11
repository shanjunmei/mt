package com.lanhun.framework.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component 
public class LogInterceptor {
	private static Logger logger = LoggerFactory
			.getLogger(LogInterceptor.class);

	public void doAfter(JoinPoint jp) {
		logger.info(jp.getTarget().getClass().getName()+"."+jp.getSignature().getName());
	}
	public void doThrowing(JoinPoint jp, java.lang.Exception ex){
		logger.info(jp.getTarget().getClass().getName()+"."+jp.getSignature().getName());
		if(ex.getCause() instanceof ConstraintViolationException){
			throw new ServiceException("error", "约束校验失败");
		}
		throw new RuntimeException(ex.getMessage());
		
	}
	public Object logAround(ProceedingJoinPoint joinPoint) { 
		Object o=null;
		Object args[]=joinPoint.getArgs();
		try {
			long t=System.currentTimeMillis();
			o=joinPoint.proceed(args);
			t=System.currentTimeMillis()-t;
			logger.info("invoke "+joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName()+" take "+t+" ms");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return o;
	}
}
