package fr.orsys.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class MonitoringAspect {
	static Logger logger = Logger.getLogger("banque.monitoring");

	public Object calculateMethodDuration(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = null;
		long debut = System.currentTimeMillis();
		result= joinPoint.proceed();
		long fin = System.currentTimeMillis();
		logger.info("methode " + joinPoint.getSignature().getName() 
				+ " duration = " + (fin-debut) + " ms");
		
		return result;
	}
}
