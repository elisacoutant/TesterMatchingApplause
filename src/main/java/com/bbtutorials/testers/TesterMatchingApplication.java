package com.bbtutorials.testers;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class TesterMatchingApplication {

	public static void main(String[] args) throws IOException, BeansException {
		SpringApplication.run(TesterMatchingApplication.class, args);

		Startup s = new Startup();
		s.runAfterStartup();
	}


}
