package com.cg.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cg.example.demo.pojo.Customer;
import com.cg.example.demo.pojo.Employee;
import com.cg.example.demo.service.CustomerService;
import com.cg.example.demo.service.EmployeeService;


@SpringBootApplication
public class DemoApplication {
	private static Logger loger=LogManager.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
    public CommandLineRunner loadInitialData(EmployeeService service) {
		loger.info("This is a info");
    	return(args)->{
    		service.addEmployee(new Employee(1011,"Div"));
    		service.addEmployee(new Employee(1022,"Rat"));
    		service.addEmployee(new Employee(1033,"Abhi"));
    		service.addEmployee(new Employee(1044,"Jay"));
    		service.addEmployee(new Employee(1055,"Nish"));
    		
    	};
	}
    	@Bean
     public CommandLineRunner loadInitialDataMongo(CustomerService custservice) {
        	return(args)->{
        		custservice.addCustomer(new Customer(101,"Div"));
        		custservice.addCustomer(new Customer(102,"Rahul"));
        		custservice.addCustomer(new Customer(103,"Joti"));
        		custservice.addCustomer(new Customer(104,"Dpk"));
        		System.out.println("MongoDb initiated");
        		
        	};
    }
}
