package com.cs.rapidapi.bean;


public class Covid19Stats {
	 private String city;
	 private String province;
	 private String country;
	 private String lastUpdate;
	 private String keyId;
	 private float confirmed;
	 private float deaths;
	 private String recovered;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getKeyId() {
		return keyId;
	}
	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}
	public float getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(float confirmed) {
		this.confirmed = confirmed;
	}
	public float getDeaths() {
		return deaths;
	}
	public void setDeaths(float deaths) {
		this.deaths = deaths;
	}
	public String getRecovered() {
		return recovered;
	}
	public void setRecovered(String recovered) {
		this.recovered = recovered;
	}

}
