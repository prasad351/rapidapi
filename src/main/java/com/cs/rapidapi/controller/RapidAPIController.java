package com.cs.rapidapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cs.rapidapi.bean.Covid19Stats;
import com.cs.rapidapi.service.RapidapiService;

@RestController
@RequestMapping(path = "/rapidApi")
public class RapidAPIController {

	Logger logger = LoggerFactory.getLogger(RapidAPIController.class);

	@Autowired
	RapidapiService rapidapiService;

	@GetMapping("/serviceUp")
//	@CircuitBreaker(name = "sericeCall",fallbackMethod = "fallBack")
	public List<Covid19Stats> getServiceUp() {
		logger.info("getServiceUp Start");
		List<Covid19Stats> covid19Stats = rapidapiService.getCovid19Stats();
		logger.info("getServiceUp End");
		return covid19Stats;

	}

	@GetMapping("/findAllCountrywithPage")
	public List<Covid19Stats> findAllCountry(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy) {
		logger.info("findAllCountry Start");
		List<Covid19Stats> covid19Stats = rapidapiService.getCovid19Stats(pageNo, pageSize, sortBy);
		logger.info("findAllCountry end");
		return covid19Stats;
	}

	public String fallBack(Exception e) {
		logger.error("Service Not Working" + e.getMessage());
		return "Service Not Working -Try again";
	}

	@GetMapping("/stats")
	public List<Covid19Stats> getAllCountry() {
		logger.info("getAllCountry Start");
		List<Covid19Stats> covid19Stats = rapidapiService.getCovid19Stats();
		System.out.println("covid19Stats " + covid19Stats.size());
		logger.info("getAllCountry End");
		return covid19Stats;

	}

	@GetMapping("/stats/{country}")
	public List<Covid19Stats> getCountry(@PathVariable("country") String country) {
		logger.info("getCountry Start");
		List<Covid19Stats> covid19Stats = rapidapiService.getCovid19Stats(country);
		logger.info("getCountry End");
		return covid19Stats;

	}

}
