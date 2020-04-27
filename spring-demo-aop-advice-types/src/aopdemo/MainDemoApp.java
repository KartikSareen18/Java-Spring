package aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aopdemo.dao.AccountDAO;
import aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read the spring config java class
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);

		//get the bean from spring container
		AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
		MembershipDAO membershipDAO=context.getBean("membershipDAO",MembershipDAO.class);
		
		//call the business method
		accountDAO.addAccount(new Account(),true);
		accountDAO.doWork();
		accountDAO.setName("abc");
		accountDAO.getName();
		
		
		membershipDAO.addAccount();
		membershipDAO.doWorkMember();

		//close the context
		context.close();
	}

}
