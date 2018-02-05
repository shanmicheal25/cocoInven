package com.inven.coco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.inven.coco.model.TblCustomers;
import com.inven.coco.service.details.ICustomerRepository;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Application implements CommandLineRunner {
	
	@Autowired
	ICustomerRepository customerRepository;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
		TblCustomers[] tblCustomer = {
				new TblCustomers( " address1", "ddress2", "KL", "GS Smart",
						"shankar", "India", "fax", "01221142", "56000"),
				new TblCustomers( " address1", "ddress2", "KL", "GS Smart",
						"Binot", "MAlayis", "fax", "01221142", "56000")
		};
		
		
		for(TblCustomers tblCust : tblCustomer) {
			customerRepository.save(tblCust);
		}
		
	}

}
