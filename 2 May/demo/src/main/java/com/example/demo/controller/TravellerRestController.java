package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.*;

import com.example.demo.entity.Traveller;

@RestController
public class TravellerRestController {

	public TravellerRestController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/welcome")
	public String hello()
	{
		return "Hell12o";
	}

	@PostMapping("/addtraveller")
	public Traveller addTraveller(@RequestBody Traveller traveller) {
		return TravellerServiceImpl.addTraveller(traveller);
	}
}
