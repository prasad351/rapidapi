package com.cs.rapidapi.bean;

import java.util.ArrayList;

public class Data {
	 private String lastChecked;
	 ArrayList < Covid19Stats > covid19Stats = new ArrayList < > ();


	 // Getter Methods 

	 public ArrayList<Covid19Stats> getCovid19Stats() {
		return covid19Stats;
	}

	public void setCovid19Stats(ArrayList<Covid19Stats> covid19Stats) {
		this.covid19Stats = covid19Stats;
	}

	public String getLastChecked() {
	  return lastChecked;
	 }

	 // Setter Methods 

	 public void setLastChecked(String lastChecked) {
	  this.lastChecked = lastChecked;
	 }
	}
