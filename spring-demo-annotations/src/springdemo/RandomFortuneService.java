package springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	//create a random array of strings
	private String[] data= {
		"The journey is the reward",
		"Diligence is the mother of good luck",
		"Beware of the wolf in sheep's clothing"
	};
	
	private Random myRandom=new Random();
	
	@Override
	public String getFortune() {
		//pick a random string from the array
		
		int index=myRandom.nextInt(data.length);
		return data[index];
	}

}
