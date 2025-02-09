package springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class CRMLoggingAspect {
	
	//setup logger
	private Logger logger=Logger.getLogger(getClass().getName());
	
	//setup pointcut declarations
	@Pointcut("execution(* springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	//add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		
		//display the  method we are calling
		String method=joinPoint.getSignature().toShortString();
		logger.info("=====>> in @Before: calling method: "+method);
		
		//display the method arguments
		Object []args=joinPoint.getArgs();
		
		for(Object arg:args) {
			logger.info("====>> argument: "+arg);
		}
	}
	
	//add @AfterReturning advice
	@AfterReturning(pointcut="forAppFlow()",returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result) {
		
		//display the  method we are returning from
		String method=joinPoint.getSignature().toShortString();
		logger.info("=====>> in @AfterReturning: from method: "+method);
		
		//display the data returned
		logger.info("====>> result: "+result);
		
	}

}
