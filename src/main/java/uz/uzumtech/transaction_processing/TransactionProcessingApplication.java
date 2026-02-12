package uz.uzumtech.transaction_processing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TransactionProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionProcessingApplication.class, args);
	}

}
