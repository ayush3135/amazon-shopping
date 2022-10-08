package com.example.demo.eureka.provider.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class ShoppingController {
	
	@Autowired
	private RestTemplate template;

	@RequestMapping("/")
	public String home() {
		return "Welcome Home";
	}

	@RequestMapping("/amazon-payment/{price}")
	public String invokePaymentService(@PathVariable int price) {
		String url ="http://PAYMENT-SERVICE/payment-provider/payNow/"+price;
		//WebClient client = WebClient.create(url);
		return template.getForObject(url, String.class);
		//return client;
	}
	
	
}
