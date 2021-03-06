package org.anhu.databaseTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FirstDemoApplicationTest {

	private static final Logger log = LoggerFactory.getLogger(FirstDemoApplicationTest.class);

	public static void main(String[] args) {
		SpringApplication.run(FirstDemoApplicationTest.class);
	}

	@Bean
	public CommandLineRunner demo(ProfileRepositoryTest repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new ProfileTest(11, "Bauer"));
			repository.save(new ProfileTest(12, "O'Brian"));
			repository.save(new ProfileTest(13, "Bauer"));
			repository.save(new ProfileTest(14, "Palmer"));
			repository.save(new ProfileTest(15, "Dessler"));

			// fetch all customers
			System.out.println("fetch all");
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (ProfileTest profile : repository.findAll()) {
				log.info(profile.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			System.out.println("fetch by id");
			repository.findById(1L).ifPresent(profile -> {
				log.info("Customer found with findById(1L):");
				log.info("--------------------------------");
				log.info(profile.toString());
				log.info("");
			});

			// fetch customers by rfid
			System.out.println("fetch by rfid");
			log.info("Customer found with rfid(12):");
			log.info("--------------------------------------------");
			repository.findByRfid(12).forEach(p -> {
				log.info(p.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// log.info(bauer.toString());
			// }

			// fetch customers by name
			System.out.println("fetch by name");
			log.info("Customer found with name(Palmer):");
			log.info("--------------------------------------------");
			repository.findByName("Palmer").forEach(p -> {
				log.info(p.toString());
			});
			log.info("");
		};
	}
}
