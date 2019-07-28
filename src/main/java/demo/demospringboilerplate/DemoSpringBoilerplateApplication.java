package demo.demospringboilerplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class DemoSpringBoilerplateApplication {

	public static void main(String[] args) {
		
		// to print out the jre/jdk version for debug
		
		String verison = System.getProperty("java.version");
		log.info("java version: " + verison);
		
		SpringApplication.run(DemoSpringBoilerplateApplication.class, args);
	}

}
