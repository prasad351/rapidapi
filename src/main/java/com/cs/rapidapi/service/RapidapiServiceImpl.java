package com.cs.rapidapi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cs.rapidapi.bean.Covid19Stats;
import com.cs.rapidapi.common.Constants;
import com.cs.rapidapi.common.RapidUtils;
import com.cs.rapidapi.model.Statas;

@Service
public class RapidapiServiceImpl implements RapidapiService {
	
	@Value("${CS.STATISTICS.URL}")
	 private  String url ;
	 @Autowired
	  RestTemplate restTemplate;
	 
	 @Autowired
	 RapidUtils rapidUtils;
	 
	 
	public List<Covid19Stats> getCovid19Stats(){

		
		Statas covid19Stats = restTemplate.exchange(url+Constants.STATS,
			  HttpMethod.GET, rapidUtils.getHeaders(), Statas.class).getBody();
			 
	      
		return covid19Stats.getData().getCovid19Stats();
		 
		 
	 }


	public List<Covid19Stats> getCovid19Stats(String country) {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("country", country);
		
		Statas covid19Stats = restTemplate.exchange(url+Constants.STATS,
				  HttpMethod.GET, rapidUtils.getHeaders(), Statas.class,params).getBody();
				 
		      
			return covid19Stats.getData().getCovid19Stats();
	}


	
	

}
