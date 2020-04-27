package aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	public String getFortune() {
		
		//simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//return the fortune
		return "Expect Heavy traffic";
		
	}

	public String getFortune(boolean tripWire) {
		if(tripWire) {
			throw new RuntimeException("RunTime Exception");
		}
		return getFortune();
	}
}
