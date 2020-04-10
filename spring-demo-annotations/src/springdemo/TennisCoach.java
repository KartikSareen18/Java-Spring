package springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("myCoach")       setting explicit bean id="myCoach"
@Component                    //setting default bean id="tennisCoach"  same name as the class but first letter lowercase
//@Scope("prototype")
public class TennisCoach implements Coach {

	private FortuneService fortuneService;
	
	@Autowired     //constructor injection
	public TennisCoach(@Qualifier("randomFortuneService")FortuneService fortuneService) { 
		System.out.println("In Tennis Coach Constructor");
		this.fortuneService = fortuneService;
	}
	
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("In Tennis Coach doMyStartupStuff function");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("In Tennis Coach doMyCleanupStuff function");
	}
}

	


