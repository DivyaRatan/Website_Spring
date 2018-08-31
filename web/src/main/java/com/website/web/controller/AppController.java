package com.website.web.controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.website.web.pojo.Customer;

@Controller
public class AppController {
	static final String url = "http://localhost:8080/customer";
	
	@RequestMapping(value="/view", method=RequestMethod.GET)	
	public String viewAllCustomer(Model model){
		RestTemplate restTemplate=new RestTemplate();
		//String viewAllCustomers="http://localhost:8080/customer";
	
//		ResponseEntity<?> responseEntity = restTemplate.getForEntity("http://localhost:8080/customer", ArrayList.class);
		ResponseEntity<?> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Customer>>(){});
		if(responseEntity.getStatusCode().equals(HttpStatus.OK)) 
			model.addAttribute("customers", responseEntity.getBody());
		else
			model.addAttribute("customers", null);
		return "view";
	}
	@RequestMapping(value="/home", method=RequestMethod.GET )	
	public String showfistpage(Model model){
		return "home";
	}
}


