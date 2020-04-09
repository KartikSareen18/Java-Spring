package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SetterInjection {

	public static void main(String[] args) {
		
		//load the spring configuration file
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container
		CricketCoach theCoach=context.getBean("myCricketCoach",CricketCoach.class);		
		
		//call methods on bean
		System.out.println(theCoach.getDailyWorkout());		
		System.out.println(theCoach.getDailyFortunes());
		
	
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		
		//close the context
		context.close();
		
			

	}

}
