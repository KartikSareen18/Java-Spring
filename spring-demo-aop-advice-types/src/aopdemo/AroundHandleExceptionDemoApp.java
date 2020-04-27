package aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aopdemo.dao.AccountDAO;
import aopdemo.dao.MembershipDAO;
import aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	public static void main(String[] args) {
		
		//read the spring config java class
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);

		//get the bean from spring container
		TrafficFortuneService trafficFortuneService=context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		System.out.println("\n\nMain Program: AroundDemoApp");
		boolean tripWire=true;
		System.out.println("My Fortune is: "+trafficFortuneService.getFortune(tripWire));
		System.out.println("Finished!!");
	
		//close the context
		context.close();
	}

}
