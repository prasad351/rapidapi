package com.cs.rapidapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.rapidapi.bean.Covid19Stats;
import com.cs.rapidapi.service.RapidapiService;

@RestController
@RequestMapping(path = "/rapidApi")
public class RapidAPIController {
	
	
	//private static final Logger logger = Logger.getLogger(RapidAPIController.class);


	
	@Autowired
	RapidapiService  rapidapiService;
	
	@GetMapping("/stats")
	public List<Covid19Stats>   getAllCountry() {
	List<Covid19Stats> 	covid19Stats =rapidapiService.getCovid19Stats();
	System.out.println("covid19Stats "+covid19Stats.size());
		 return covid19Stats;
			
	}
	
	@GetMapping("/stats/{country}")
	public List<Covid19Stats>   getCountry(@PathVariable("country") String country) {
		
		System.out.println("HHHHHHHH"+country);
	List<Covid19Stats> 	covid19Stats =rapidapiService.getCovid19Stats(country);
	System.out.println("HHHHHHHHcountry "+covid19Stats.size());
		 return covid19Stats;
			
	}
	
	@GetMapping("/simple")
	public String getSimple() {
		
		//Covid19Statss	covid19Stats =rapidapiService.getCovid19Stats();
		return "Prasad";
			
	}

}
