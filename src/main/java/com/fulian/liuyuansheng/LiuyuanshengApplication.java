package com.fulian.liuyuansheng;

import com.fulian.liuyuansheng.hello.domain.Customer;
import com.fulian.liuyuansheng.hello.dao.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;

@SpringBootApplication
@EnableJpaRepositories(queryLookupStrategy = QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND)
public class LiuyuanshengApplication {
	private static final Logger log = LoggerFactory.getLogger(LiuyuanshengApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LiuyuanshengApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));
			repository.save(new Customer("Mi", "Dessler"));
//			long deleteCount = repository.countByLastName("Bauer");
//			long ci = repository.deleteByLastName("Bauer");
//			System.out.println("deleted count = " + deleteCount + "," + ci);
			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (Customer customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//			log.info("");
//
//			// fetch an individual customer by ID
//			repository.findById(1L)
//					.ifPresent(customer -> {
//						log.info("Customer found with findById(1L):");
//						log.info("--------------------------------");
//						log.info(customer.toString());
//						log.info("");
//					});
//
//			// fetch customers by last name
//			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}
}