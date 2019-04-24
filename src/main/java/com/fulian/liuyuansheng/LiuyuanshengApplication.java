package com.fulian.liuyuansheng;

import com.fulian.liuyuansheng.zhouyunlian.dao.UserRepository;
import com.fulian.liuyuansheng.zhouyunlian.domain.Customer;
import com.fulian.liuyuansheng.zhouyunlian.dao.CustomerRepository;
import com.fulian.liuyuansheng.zhouyunlian.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.config.BootstrapMode;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(queryLookupStrategy = QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND,bootstrapMode = BootstrapMode.LAZY)
public class LiuyuanshengApplication {
	private static final Logger log = LoggerFactory.getLogger(LiuyuanshengApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LiuyuanshengApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(CustomerRepository repository, UserRepository userRepository) {
		return (args) -> {
			// save a couple of customers

			repository.save(new Customer(1L,"cc2","Bauer"));
			repository.save(new Customer(2L,"cc3","O'Brian"));
			repository.save(new Customer(3L,"Bauer","a3"));
			repository.save(new Customer(4L,"Palmer","a4"));
			repository.save(new Customer(5L,"Dessler1","a5"));
			repository.save(new Customer(6L,"Bauer3","a6"));
			repository.save(new Customer(7L,"Bauer4","a7"));
			repository.save(new Customer(8L,"Bauer5","a8"));
			repository.save(new Customer(9L,"Bauer6","a9"));
			//
			userRepository.save(new User(1L,"333"));

			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			log.info("");

		};
	}
}
