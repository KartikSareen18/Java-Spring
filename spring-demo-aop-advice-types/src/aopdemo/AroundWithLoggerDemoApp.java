package aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aopdemo.dao.AccountDAO;
import aopdemo.dao.MembershipDAO;
import aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	private static Logger logger=Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	public static void main(String[] args) {
		
		//read the spring config java class
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);

		//get the bean from spring container
		TrafficFortuneService trafficFortuneService=context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		logger.info("\n\nMain Program: AroundDemoApp");
		
		logger.info("My Fortune is: "+trafficFortuneService.getFortune());
		logger.info("Finished!!");
	
		//close the context
		context.close();
	}

}
