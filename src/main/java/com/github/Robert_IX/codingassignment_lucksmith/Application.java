package com.github.Robert_IX.codingassignment_lucksmith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Spring Boot application.
 * This class bootstraps the application, initializing the Spring context and launching the embedded server.
 *
 * The @SpringBootApplication annotation encapsulates @Configuration, @EnableAutoConfiguration,
 * and @ComponentScan, which are essential for auto-configuring the Spring context.
 *
 * @author Robert Gheorghe
 */
@SpringBootApplication
public class Application
{

	/**
	 * Main method used to run the application.
	 * This method starts the entire Spring Boot application by invoking SpringApplication.run().
	 *
	 * @param args command line arguments (if any)
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}