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
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.config.BootstrapMode;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * less invasive and more  flexible
 *
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableJpaRepositories(queryLookupStrategy = QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND,bootstrapMode = BootstrapMode.LAZY)
public class LiuyuanshengApplication {


	private  static  final  String INITAL_VERSION = "1";
	private static final Logger log = LoggerFactory.getLogger(LiuyuanshengApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LiuyuanshengApplication.class, args);
	}



	@Bean
	public CommandLineRunner demo(CustomerRepository repository, UserRepository userRepository) {
		return (args) -> {
			// save a couple of customers

			repository.save(new Customer("cc2","Bauer",INITAL_VERSION));
			repository.save(new Customer("cc3","O'Brian",INITAL_VERSION));
			repository.save(new Customer("Bauer","a3",INITAL_VERSION));
			repository.save(new Customer("Palmer","a4",INITAL_VERSION));
			repository.save(new Customer("Dessler1","a5",INITAL_VERSION));
			repository.save(new Customer("Bauer3","a6",INITAL_VERSION));
			repository.save(new Customer("Bauer4","a7",INITAL_VERSION));
			repository.save(new Customer("Bauer5","a8",INITAL_VERSION));
			repository.save(new Customer("Bauer6","a9",INITAL_VERSION));
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
