package spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration                // for using java configuration(no XML)
@ComponentScan("spring")      //package to scan for the components and create bean automatically
public class SportConfig {
	

}
