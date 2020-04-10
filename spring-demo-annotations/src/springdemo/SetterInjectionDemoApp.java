package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjectionDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Coach theCoach=context.getBean("myCoach",Coach.class);
		
		CricketCoach theCoach=context.getBean("cricketCoach",CricketCoach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTeam());
		
		context.close();

	} 

}
