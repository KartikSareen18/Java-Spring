package springdemo;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileFortuneService implements FortuneService {

	private String filename="D:\\eclipse\\spring-demo-annotations\\src\\springdemo\\fortune-data.txt";
	
	private List<String> theFortunes;
	
	private Random myRandom=new Random();
	
	public FileFortuneService() {
		
		System.out.println("FileFortuneService: in constructor");
		theFortunes=new ArrayList<String>();
	}
	
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("In FileFortuneService method loadTheFortunesFile");
		File file=new File(filename);
		
		try (BufferedReader br=new BufferedReader(new FileReader(file))){
			
			String line;
			while((line=br.readLine())!=null) {
				theFortunes.add(line);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String getFortune() {
		int index=myRandom.nextInt(theFortunes.size());
		
		return theFortunes.get(index);
 	}

}
