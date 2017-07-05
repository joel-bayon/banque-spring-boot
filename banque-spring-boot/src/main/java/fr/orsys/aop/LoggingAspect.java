package fr.orsys.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
	
@Before("execution(* fr.orsys.dao.*.*(..)) or execution(* fr.orsys.service.*.*(..))" )
	public void logBefore(JoinPoint joinPoint) {
	 	Logger logger = Logger.getLogger(joinPoint.getTarget().getClass());
		logger.info(joinPoint.getSignature().toString());
		 
	}


}
