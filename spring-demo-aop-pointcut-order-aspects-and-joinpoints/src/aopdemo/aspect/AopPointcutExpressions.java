package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopPointcutExpressions {
		
		//pointcut declarations
		@Pointcut("execution(* aopdemo.dao.*.*(..))")
		public void forDAOPackage() {}

		@Pointcut("execution(* aopdemo.dao.*.get*(..))")
		public void getter() {}
		
		@Pointcut("execution(* aopdemo.dao.*.set*(..))")
		public void setter() {}
		
		@Pointcut("forDAOPackage() && !(getter() || setter())")
		public void forDAOPackageNoGetterSetter() {}
}
