package com.cs.rapidapi.service;

import java.util.List;

import com.cs.rapidapi.bean.Covid19Stats;

public interface RapidapiService {
	
	public List<Covid19Stats> getCovid19Stats();
	public List<Covid19Stats> getCovid19Stats(String country);
	

}
