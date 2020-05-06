package com.fantastic4.restapi.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SMSController {
	
	int co2;
	int smoke;
	
	private final RestTemplate restTemplate;
	
	 public SMSController(RestTemplateBuilder restTemplateBuilder) {
	        this.restTemplate = restTemplateBuilder.build();
	    }
	
	 
	public String checkSmoke(int co2, int smoke) {
		
		if(co2 > 5 || smoke > 5)
		{
			 String url = "http://localhost:9090/send-sms";
		        return this.restTemplate.getForObject(url, String.class);
		}
		return null;
		
	}
	

}
