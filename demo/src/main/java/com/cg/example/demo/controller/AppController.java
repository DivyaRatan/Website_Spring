package com.cg.example.demo.controller;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
	import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

	import java.util.ArrayList;
	import java.util.Collection;
	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.hateoas.Link;
	import org.springframework.hateoas.Resource;
	import org.springframework.hateoas.Resources;
	import org.springframework.hateoas.mvc.ControllerLinkBuilder;
	import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.ResponseBody;
	import org.springframework.web.bind.annotation.RestController;

import com.cg.example.demo.pojo.Customer;
import com.cg.example.demo.pojo.Employee;
import com.cg.example.demo.service.CustomerService;
import com.cg.example.demo.service.EmployeeService;


	
	@CrossOrigin
	@RestController
	public class AppController {
		@Autowired
		private EmployeeService employeeserv;
		@Autowired
		private CustomerService customerserv;
		
		//Getting All Employee
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/employee/{start}/{count}",method=RequestMethod.GET)
		public Resources getEmployee(@PathVariable("start") int start,@PathVariable("count") int count){
			List<Employee> tempraryemployee=(List<Employee>)employeeserv.viewAllEmployee();
			int listlength=tempraryemployee.size();
			List<Employee> employee=new ArrayList<>();
			for(int i=start-1;i<start+count-1;i++) {
				employee.add(tempraryemployee.get(i));
			}
			Link previousLink=linkTo(methodOn(this.getClass()).getEmployee(start-count>0?start-count:1, count)).withRel("previous");
			Link nextLink=linkTo(methodOn(this.getClass()).getEmployee(start+count<listlength-1?start+count:listlength-count+1, count)).withRel("next");
			return new Resources<>(employee, previousLink, nextLink);
			
		}
		
		//Getting Employee By Id
		//@RequestMapping(value="/employee/{employeeId}",method=RequestMethod.GET)
		
		
		//Adding Employee
		@RequestMapping(value="/employee/add",method=RequestMethod.POST)
		public void addEmployee(@RequestBody Employee emp){
			System.out.println("Employee Added");
			employeeserv.addEmployee(emp);
		}
		
		//Updating Employee
		@RequestMapping(value="/employee/update",method=RequestMethod.PUT,consumes="application/json")
		public void updateEmployee(@RequestBody Employee emp){
			System.out.println("Update Employee" );
			employeeserv.updateEmployee(emp);
		}
		
		//Deleting Employee By Id
		@RequestMapping(value="/employee/{employeeId}",method=RequestMethod.DELETE)
		@ResponseBody
		public ResponseEntity<String> deleteEmployee(@PathVariable int employeeId){
			employeeserv.deleteEmployee(employeeId);
			return new ResponseEntity<String>("Entity Deleted", HttpStatus.OK);
		}
		
		@RequestMapping(value="/customer/{customerId}", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
		public Resource<Customer> viewCustomer(@PathVariable int customerId) {
			//Link link = linkTo(methodOn(this.getClass()).addCustomer()).withRel("Add Customer");
			return new Resource(customerserv.viewCustomer(customerId));
			
		}
		@RequestMapping(value = "/customer")
		public ResponseEntity<?> viewAllCustomer() {
			List<Customer> customers = customerserv.viewAllCustomers();
			if (customers.size() != 0)
				return new ResponseEntity<>(customers, HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
