package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TravellerRestController {

	public TravellerRestController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/welcome")
	public String hello()
	{
		return "Hello";
	}

}
