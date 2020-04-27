package aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	// add a new advice Around on the getFortune method
	@Around("execution(* aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortuneServiceAdvice(ProceedingJoinPoint proceedingJoinPoint)throws Throwable {
		
		//print out the method we are advising on
		String method=proceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n==>>Executing @Around on method : "+method);
		
		// get begin timestamp
		long begin=System.currentTimeMillis();
		
		// execute the method
		Object result=null;
		
		try {
			result=proceedingJoinPoint.proceed();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			
			//for rethrowing exception
			throw ex;
			
			//for handling exception
			//result="Nothing Here";
		}
		//get end timestamp
		long end=System.currentTimeMillis();
		
		//complete duration and display it
		long duration=end-begin;
		System.out.println("Execution time: "+duration/1000.0 + "seconds");
		
		return result;
	}
	
	
	// add a new advice After(Finally) on the findAccounts method
	@After("execution(* aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		String method=joinPoint.getSignature().toShortString();
		System.out.println("\n==>>Executing @After (Finally) on method : "+method);
	}
	
	// add a new advice AfterThrowing on the findAccounts method
	@AfterThrowing(pointcut="execution(* aopdemo.dao.AccountDAO.findAccounts(..))",throwing="ex")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint,Throwable ex) {
		String method=joinPoint.getSignature().toShortString();
		System.out.println("\n==>>Executing @AfterThrowing on method : "+method);
		System.out.println("\n===>> exception is: "+ex);
	}
	
	//add a new advice for AfterReturning on the findAccounts method
	@AfterReturning(pointcut="execution(* aopdemo.dao.AccountDAO.findAccounts(..))",returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint,List<Account>result) {
		String method=joinPoint.getSignature().toShortString();
		System.out.println("\n==>>Executing @AfterReturning on method : "+method);
		System.out.println("\n===>> result is: "+result);
	
		// post-process the data ...modify it before sending 
		
		//convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		System.out.println("\n===>> after processing ,result is: "+result);
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		for(Account acc:result) {
			String name=acc.getName().toUpperCase();
			acc.setName(name);
		}
		
	}

	@Before("aopdemo.aspect.AopPointcutExpressions.forDAOPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n>>>Executing @Before advice on methods");
	
		//display the method Signature
		MethodSignature methodSig=(MethodSignature) joinPoint.getSignature();
		System.out.println("Method: "+methodSig);
		
		//display the method arguments
		Object[] args=joinPoint.getArgs();
		
		for(Object arg:args) {
			System.out.println(arg);
			
			if(arg instanceof Account) {
				//downcast and print AccountStuff
				Account acc=(Account)arg;
				System.out.println("Account name: "+acc.getName());
			}
		}
	}
}
