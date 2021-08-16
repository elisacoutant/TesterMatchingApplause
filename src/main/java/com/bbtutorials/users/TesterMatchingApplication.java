package com.bbtutorials.users;

import com.bbtutorials.users.service.TestersService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class TesterMatchingApplication {

	public static void main(String[] args) throws IOException, BeansException {
		SpringApplication.run(TesterMatchingApplication.class, args);

		Startup s = new Startup();
		s.runAfterStartup();
	}


}
