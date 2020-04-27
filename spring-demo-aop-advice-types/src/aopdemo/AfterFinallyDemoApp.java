package aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aopdemo.dao.AccountDAO;
import aopdemo.dao.MembershipDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		
		//read the spring config java class
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);

		//get the bean from spring container
		AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
		
		try {
			//flag to simulate exceptions
			boolean tripWire=false;
			List<Account> accs=accountDAO.findAccounts(tripWire);
			System.out.println(accs);	
		}
		catch(Exception ex)
		{
			System.out.println("\n\nMain Program:AfterThrowingDemoApp");
			System.out.println(ex);
		}
	
		//close the context
		context.close();
	}

}
