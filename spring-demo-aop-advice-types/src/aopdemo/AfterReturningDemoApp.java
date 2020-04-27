package aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aopdemo.dao.AccountDAO;
import aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		//read the spring config java class
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);

		//get the bean from spring container
		AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
		
		List<Account> accs=accountDAO.findAccounts(false);

		System.out.println("\n\nMain Program:AfterReturningDemoApp");
		System.out.println(accs);		
		
		//close the context
		context.close();
	}

}
