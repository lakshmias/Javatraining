package com.dal.firstsprboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dal.firstsprboot.entity.ForeignTour;
import com.dal.firstsprboot.entity.LocalTour;
import com.dal.firstsprboot.entity.Traveller;
import com.dal.firstsprboot.service.TravellerService;
import java.util.List;
import java.util.Optional;
@RestController

public class TravellerRestController {
	@Autowired
	TravellerService travellerService;
	
	@GetMapping("/welcome")
	public String helloAppln() {
		return "Hi Traveller";
	}
	
	@PostMapping("/addtraveller")	
	public Traveller addTraveller(@RequestBody Traveller traveller) {
		return travellerService.addTraveller(traveller);
	}

	@PostMapping("/requestlocaltour")
	public LocalTour saveLocalTourRequest(@RequestBody LocalTour localTour) {
		return travellerService.saveLocalTourRequest(localTour);
	}

	@PostMapping("/requestforeigntour")
	public ForeignTour saveForeignTourRequest(@RequestBody ForeignTour foreignTour) {
		System.out.println("****** From Controller Foreign ******" + foreignTour);
		return travellerService.saveForeignTourRequest(foreignTour);
	}
	
	@GetMapping("/listtraveller")
	public List<Traveller> getTravellerList()
	{
		return travellerService.getTravellerList();
	}
	
	@GetMapping("/byid/{tid}")
	public Optional<Traveller> getTravellerByID(@PathVariable long tid)
	{
		return travellerService.getTravellerByID(tid);
	}
}
