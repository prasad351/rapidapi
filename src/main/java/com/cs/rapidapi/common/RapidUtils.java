package com.cs.rapidapi.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class RapidUtils {

	@Value("${CS.STATISTICS.HOST}")
	private String host;
	@Value("${CS.STATISTICS.KEY}")
	private String key;

	public HttpEntity<String> getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		// headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set(Constants.RAPIDAPI_HOST, host);
		headers.set(Constants.RAPIDAPI_KEY, key);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return entity;
	}
}
