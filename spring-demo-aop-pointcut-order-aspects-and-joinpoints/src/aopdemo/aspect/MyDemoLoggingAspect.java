package aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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
