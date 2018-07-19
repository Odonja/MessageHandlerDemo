package org.anhu.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstDemoApplication {

	// http://javasampleapproach.com/spring-framework/spring-boot/integrate-h2-database-springboot-spring-jpa-embedded-mode
	public static void main(String[] args) {
		SpringApplication.run(FirstDemoApplication.class, args);
	}
}
