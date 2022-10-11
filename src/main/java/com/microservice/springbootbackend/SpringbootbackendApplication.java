package com.microservice.springbootbackend;

import com.microservice.springbootbackend.Models.Billings;
import com.microservice.springbootbackend.Repository.BillingRepository;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootbackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootbackendApplication.class, args);
	}

	@Autowired
	private BillingRepository billingRepository;
	@Override
	public void run(String... args) throws Exception {
//		Billings viewBillings = new Billings();
//		viewBillings.setName("Gym");
//		viewBillings.setType("Health and Wellness");
//		viewBillings.setCategoryid("1");
//		viewBillings.setAmount(30000);
//		billingRepository.save(viewBillings);
//
//		Billings viewBillings1 = new Billings();
//		viewBillings1.setName("Shopping");
//		viewBillings1.setType("Household");
//		viewBillings1.setCategoryid("2");
//		viewBillings1.setAmount(50000);
//		billingRepository.save(viewBillings1);
//
//		Billings viewBillings2 = new Billings();
//		viewBillings2.setName("Rent");
//		viewBillings2.setType("Household");
//		viewBillings2.setCategoryid("3");
//		viewBillings2.setAmount(120000);
//		billingRepository.save(viewBillings2);
	}
}
