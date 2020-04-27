package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudLogAspect {
	
	@Before("aopdemo.aspect.AopPointcutExpressions.forDAOPackageNoGetterSetter()")
	public void logToCloud() {
		System.out.println("\n>>>Logging to Cloud");
	}

}
