package com.bbm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bbm.entity.Specimen;
import com.bbm.repo.BbmSpecimenRepository;
import com.bbm.service.BbmSpecimenService;

@RestController
public class BbmController {
	@Autowired
	BbmSpecimenService bbmService;
	
	@Autowired
	BbmSpecimenRepository bbmSpecimenRepository;
	
	@GetMapping("/welcome")
	public String helloAppln() {
		return "Hi Blood Bank Management";
	}
	
	@PostMapping("/addSpecimen")	
	public Specimen addSpecimen(@RequestBody Specimen bbmSpecimen) {
		return bbmService.addSpecimen(bbmSpecimen);
	}

	@GetMapping("/specimen/{OID}")
	public Specimen getSpecimenByOID(@PathVariable Long OID)
	{
		return bbmService.findSpecimentByOID(OID);
	}
}
