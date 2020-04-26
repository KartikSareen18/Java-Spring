package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//pointcut declarations
	@Pointcut("execution(* aopdemo.dao.*.*(..))")
	private void forDAOPackage() {}

	@Pointcut("execution(* aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	@Pointcut("execution(* aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	private void forDAOPackageNoGetterSetter() {}
	
	@Before("forDAOPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n>>>Executing @Before advice on all methods");
	}
	
	@Before("forDAOPackageNoGetterSetter()")
	public void anotherAdvice() {
		System.out.println("\n>>>Executing @Before another advice on methods other than getter/setter ");
	}
}
