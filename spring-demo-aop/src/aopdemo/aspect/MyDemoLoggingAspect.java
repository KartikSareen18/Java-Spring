package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//this is where we add all of our related advices for logging
	
	//start with an @Before advice
	
	//match addAccount() method in any class //pointcut expression
	//@Before("execution(public void addAccount())")
	
	//match addAccount in AccountDAO class
	//@Before("execution(public void aopdemo.dao.AccountDAO.addAccount())")
	
	//match add* method in any class
	//@Before("execution(public void add*())")
	
	//match any return type and  zero param
	//@Before("execution(* add*())")
	
	//match the param type , .. means 0 to n no. of args
	//@Before("execution(* add*(aopdemo.Account,..))")
	
	// match any params
	//@Before("execution(* add*(..))")
	
	//match methods in a given package any return type ,given package.anyclass.anymethod( 0 to more param)
	@Before("execution(* aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("\n>>>Executing @Before advice on method");
	}
}
