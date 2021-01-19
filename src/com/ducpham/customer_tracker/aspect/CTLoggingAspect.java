package com.ducpham.customer_tracker.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CTLoggingAspect {
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.ducpham.customer_tracker.controller.*.*(..))")
	public void logForController() {
		
	}
	
	@Pointcut("execution(* com.ducpham.customer_tracker.service.*.*(..))")
	public void logForService() {
		
	}
	
	@Pointcut("execution(* com.ducpham.customer_tracker.dao.*.*(..))")
	public void logForDao() {
		
	}
	
	@Pointcut("logForController() || logForService() || logForDao()")
	public void logForAll() {
		
	}
	
	
	@Before("logForAll()")
	public void logBefore(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("====> in the @Before"+method);
	}
	
	@AfterReturning(pointcut = "logForAll()",returning="result")
	public void logAfter(JoinPoint joinPoint, Object result) {
		myLogger.info("====> in the @After");
		myLogger.info("====> result:"+result);
	}
}
